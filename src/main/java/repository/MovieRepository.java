package repository;

import domain.Movie;

import java.util.List;

public interface MovieRepository {
    void save(Movie movie);
    Movie findById(Long id);
    List<Movie> findAll();
    void delete(Long id);
}
