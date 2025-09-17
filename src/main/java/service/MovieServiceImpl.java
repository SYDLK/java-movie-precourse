package service;

import domain.Movie;
import repository.MovieRepository;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public void join(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie findMovie(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }
}
