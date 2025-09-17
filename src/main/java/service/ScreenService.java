package service;

import domain.Screening;

import java.util.List;

public interface ScreenService {
    void join(Screening screening);
    Screening findScreening(Long id);
    List<Screening> findAllScreenings();
    void deleteScreening(Long id);
}
