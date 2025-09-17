package repository;

import domain.Movie;
import domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMovieRepository implements MovieRepository {
    private static Map<Long, Movie> store = new HashMap<>();

    @Override
    public void save(Movie movie) {
        store.put(movie.getId(),movie);
    }

    @Override
    public Movie findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
