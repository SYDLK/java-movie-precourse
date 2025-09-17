package service;

import domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MemoryMovieRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieServiceImpl(new MemoryMovieRepository());
    }

    @Test
    void join() {
        // given
        Movie movie = new Movie(
                1L,
                "마법의 돌",
                LocalDate.of(2025,5,19),
                LocalDate.of(2025,5,30));

        // when
        movieService.join(movie);
        Movie find = movieService.findMovie(1L);

        // then
        assertThat(find.getTitle()).isEqualTo("마법의 돌");
        assertThat(find.getStartDate()).isEqualTo(LocalDate.of(2025,5,19));
        assertThat(find.getEndDate()).isEqualTo(LocalDate.of(2025,5,30));
    }

    @Test
    void findMovie() {
        // given
        Movie movie1 = new Movie(2L, "아바타", LocalDate.of(2025,6,19), LocalDate.of(2025,6,30));

        // when
        movieService.join(movie1);

        // then
        assertThat(movie1).isEqualTo(movieService.findMovie(2L));
    }

    @Test
    void findAllMovies() {
        // given
        movieService.join(new Movie(3L,"차를로스성 3세의 모험",LocalDate.of(2025,7,19),LocalDate.of(2025,7,30)));
        movieService.join(new Movie(4L, "F1",LocalDate.of(2025,8,19),LocalDate.of(2025,8,30)));

        // when
        List<Movie> movies = movieService.findAllMovies();


        // then
        assertThat(movies).hasSize(2);
    }

    @Test
    void deleteMovie() {
        // given
        movieService.join(new Movie(5L,"영화기억안남",LocalDate.of(2025,8,19),LocalDate.of(2025,8,30)));

        // when
        movieService.deleteMovie(5L);
        Movie deleted = movieService.findMovie(5L);

        // then
        assertThat(deleted).isNull();
    }
}