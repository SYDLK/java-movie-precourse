package repository;

import domain.Reservation;

import java.util.List;

public interface ReservationRepository {
    void save(Reservation reservation);
    Reservation findById(Long id);
    List<Reservation> findAll();
    void delete(Long id);

    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByScreeningId(Long screeningId);
}
