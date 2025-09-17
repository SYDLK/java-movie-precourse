package service;

import domain.Screening;
import repository.MemoryScreenRepository;
import repository.ScreenRepository;

import java.util.ArrayList;
import java.util.List;

public class ScreenServiceImpl implements ScreenService {
    ScreenRepository screenrepository;
    public ScreenServiceImpl(ScreenRepository screenrepository) {
        this.screenrepository = screenrepository;
    }

    @Override
    public void join(Screening screening) {
        screenrepository.save(screening);
    }

    @Override
    public Screening findScreening(Long id) {
        return screenrepository.findById(id);
    }

    @Override
    public List<Screening> findAllScreenings() {
        return screenrepository.findAll();
    }

    @Override
    public void deleteScreening(Long id) {
        screenrepository.delete(id);
    }
}
