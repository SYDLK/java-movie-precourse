package service;

import domain.Seat;

import java.util.List;

public interface SeatService {
    void join(Seat seat);
    Seat findSeat(Long id);
    List<Seat> findAllSeats();
    void deleteSeat(Long id);

    String CheckSeatAvailable(Long seatId);
    List<Seat> findSeatsByScreening(Long screeningId);
}
