package service;

import domain.Movie;

import java.util.List;

public interface MovieService {
    void join(Movie movie);
    Movie findMovie(Long id);
    List<Movie> findAllMovies();
    void deleteMovie(Long id);
}
