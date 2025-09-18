package service;

import domain.Seat;
import repository.SeatRepository;

import java.util.List;

public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public void join(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public Seat findSeat(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public List<Seat> findAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.delete(id);
    }

    @Override
    public String CheckSeatAvailable(Long seatId) {
        Seat seat = seatRepository.findById(seatId);
        if(seat == null){
            return "좌석이 존재하지 않습니다.";
        }
        if(!seat.isReserved()){
            return "예약 가능합니다.";
        }
        return "예약 불가능합니다.";
    }


    @Override
    public List<Seat> findSeatsByScreening(Long screeningId) {
        return seatRepository.findAll().stream()
                .filter(seat -> seat.getScreeningId().equals(screeningId))
                .toList();
    }
}
