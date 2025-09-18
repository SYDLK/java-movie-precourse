package service;

import domain.*;
import repository.ReservationRepository;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatService seatService;
    private final ScreenService screenService;
    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  SeatService seatService,
                                  ScreenService screenService,
                                  UserService userService) {
        this.reservationRepository = reservationRepository;
        this.seatService = seatService;
        this.screenService = screenService;
        this.userService = userService;
    }

    @Override
    public void join(Reservation reservation) {
        // 1. 좌석 검증
        Seat seat = seatService.findSeat(reservation.getSeatId());
        if (seat == null) {
            throw new IllegalArgumentException("좌석이 존재하지 않습니다.");
        }
        if (!seatService.CheckSeatAvailable(seat.getId()).equals("예약 가능합니다.")) {
            throw new IllegalStateException("이미 예약된 좌석입니다.");
        }

        // 2. 상영 검증 및 겹침 방지
        Screening newScreening = screenService.findScreening(reservation.getScreeningId());
        if (newScreening == null) {
            throw new IllegalArgumentException("상영 정보가 존재하지 않습니다.");
        }

        List<Reservation> existing = findReservationsByUser(reservation.getUserId());
        for (Reservation r : existing) {
            Screening old = screenService.findScreening(r.getScreeningId());
            if (isOverlap(old, newScreening)) {
                throw new IllegalStateException("상영 시간이 겹칩니다.");
            }
        }

        // 3. 기본 가격
        int price = reservation.getPrice();

        // 4. 무비데이 할인
        int day = newScreening.getStartTime().getDayOfMonth();
        if (day == 10 || day == 20 || day == 30) {
            price = (int)(price * 0.9);
        }

        // 5. 시간 조건 할인
        int hour = newScreening.getStartTime().getHour();
        if (hour < 11 || hour >= 20) {
            price -= 2000;
        }

        // 6. 포인트 사용
        User user = userService.findUser(reservation.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("사용자가 존재하지 않습니다.");
        }
        int usePoint = Math.min(user.getScore(), price);
        price -= usePoint;
        user.usePoints(usePoint);

        // 7. 결제 수단 할인
        if (reservation.getPaymentType() == PaymentType.CARD) {
            price = (int)(price * 0.95);
        } else if (reservation.getPaymentType() == PaymentType.CASH) {
            price = (int)(price * 0.98);
        }

        // 최종 가격 저장
        reservation.setFianlPrice(price);

        // 8. 좌석 예약 처리
        seat.reserve();

        // 9. 저장
        reservationRepository.save(reservation);
    }

    private boolean isOverlap(Screening a, Screening b) {
        return a.getStartTime().isBefore(b.getEndTime())
                && b.getStartTime().isBefore(a.getEndTime());
    }

    @Override
    public Reservation findReservation(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.delete(id);
    }

    @Override
    public List<Reservation> findReservationsByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> findReservationsByScreening(Long screeningId) {
        return reservationRepository.findByScreeningId(screeningId);
    }
}
