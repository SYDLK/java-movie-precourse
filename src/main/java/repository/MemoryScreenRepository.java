package repository;

import domain.Screening;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryScreenRepository implements ScreenRepository {
    HashMap<Long, Screening> screensStore = new HashMap<>();

    @Override
    public void save(Screening screening) {
        screensStore.put(screening.getId(), screening);
    }

    @Override
    public Screening findById(Long id) {
        return screensStore.get(id);
    }

    @Override
    public List<Screening> findAll() {
        return new ArrayList<>(screensStore.values());
    }

    @Override
    public void delete(Long id) {
        screensStore.remove(id);
    }
}
