package repository;

import domain.Screening;

import java.util.List;

public interface ScreenRepository {
    void save(Screening id);
    Screening findById(Long id);
    List<Screening> findAll();
    void delete(Long id);
}
