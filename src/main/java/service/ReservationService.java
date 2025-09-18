package service;

import domain.Reservation;
import java.util.List;

public interface ReservationService {
    void join(Reservation reservation);
    Reservation findReservation(Long id);
    List<Reservation> findAllReservations();
    void deleteReservation(Long id);

    List<Reservation> findReservationsByUser(Long userId);
    List<Reservation> findReservationsByScreening(Long screeningId);
}
