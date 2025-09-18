package repository;

import domain.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemorySeatRepository implements SeatRepository {
    HashMap<Long, Seat> seatStore = new HashMap<>();

    @Override
    public void save(Seat seat) {
        seatStore.put(seat.getId(), seat);
    }

    @Override
    public Seat findById(Long id) {
        return seatStore.get(id);
    }

    @Override
    public List<Seat> findAll() {
        return new ArrayList<>(seatStore.values());
    }

    @Override
    public void delete(Long id) {
        seatStore.remove(id);
    }
}
