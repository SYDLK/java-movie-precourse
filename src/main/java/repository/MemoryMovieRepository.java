package repository;

import domain.Movie;
import domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMovieRepository implements MovieRepository {
    private static Map<Long, Movie> movieStore = new HashMap<>();

    @Override
    public void save(Movie movie) {
        movieStore.put(movie.getId(),movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieStore.get(id);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movieStore.values());
    }

    @Override
    public void delete(Long id) {
        movieStore.remove(id);
    }
}
