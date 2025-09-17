package repository;

import domain.Movie;
import domain.User;

import java.util.List;

public interface MovieRepository {
    void save(Movie movie);
    Movie findById(Long id);
    List<Movie> findAll();
    void delete(Long id);
}
