import java.time.LocalDateTime;
import java.util.HashMap;

public class MovieModel {
    HashMap<Long, Movie> movies = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public Movie getMovie(Long id) {
        return movies.get(id);
    }

    public void initMovies() {
        addMovie(new Movie(1L, "F1 더 무비", 12000, LocalDateTime.of(2025, 9, 20, 13, 0),
                LocalDateTime.of(2025, 9, 20, 15, 0)));
        addMovie(new Movie(2L, "토이 스토리", 10000,LocalDateTime.of(2025, 10, 20, 13, 0),
                LocalDateTime.of(2025, 10, 20, 15, 0)));
        addMovie(new Movie(3L, "아이언맨", 11000,LocalDateTime.of(2025, 11, 20, 13, 0),
                LocalDateTime.of(2025, 11, 20, 15, 0)));
    }
}
