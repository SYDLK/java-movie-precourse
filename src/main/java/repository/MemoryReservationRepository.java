package repository;

import domain.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryReservationRepository implements ReservationRepository {
    HashMap<Long, Reservation> ReservationStore = new HashMap<>();

    @Override
    public void save(Reservation reservation) {
        ReservationStore.put(reservation.getId(), reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return ReservationStore.get(id);
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(ReservationStore.values());
    }

    @Override
    public void delete(Long id) {
        ReservationStore.remove(id);
    }

    //GPT 활용부분
    @Override
    public List<Reservation> findByUserId(Long userId) {
        return ReservationStore.values().stream()
                .filter(r -> r.getUserId().equals(userId))
                .toList();
    }

    //GPT 활용부분
    @Override
    public List<Reservation> findByScreeningId(Long screeningId) {
        return ReservationStore.values().stream()
                .filter(r -> r.getScreeningId().equals(screeningId))
                .toList();
    }
}
