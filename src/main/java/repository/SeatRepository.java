package repository;

import domain.Seat;

import java.util.List;

public interface SeatRepository {
    void save(Seat id);
    Seat findById(Long id);
    List<Seat> findAll();
    void delete(Long id);
}
