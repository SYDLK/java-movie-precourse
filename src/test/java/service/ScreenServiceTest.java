package service;

import domain.Movie;
import domain.Screening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MemoryMovieRepository;
import repository.MemoryScreenRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScreenServiceTest {
    ScreenService screenService;
    MovieService movieService;

    @BeforeEach
    void setUp() {
        screenService = new ScreenServiceImpl(new MemoryScreenRepository());
        movieService = new MovieServiceImpl(new MemoryMovieRepository());
    }

    @Test
    void join() {
        // given
        Movie movie = new Movie(2L, "바람의 나라",
                LocalDate.of(2025,4,1),
                LocalDate.of(2025,4,2));
        movieService.join(movie);

        Screening screening = new Screening(
                1L,
                movie.getId(),
                LocalDateTime.of(2025, 4, 1, 10, 0),
                LocalDateTime.of(2025, 4, 1, 12, 0)
        );

        // when
        screenService.join(screening);
        Screening screen = screenService.findScreening(1L);
        Movie movie1 = movieService.findMovie(screen.getMovieId());

        // then
        assertThat(screen.getId()).isEqualTo(1L);
        assertThat(screen.getMovieId()).isEqualTo(movie1.getId());
        assertThat(movie1.getTitle()).isEqualTo("바람의 나라");
    }

    @Test
    void findScreening() {
        // given
        Screening screening = new Screening(
                1L,
                2L,
                LocalDateTime.of(2025, 4, 1, 14, 0),
                LocalDateTime.of(2025, 4, 1, 16, 0)
        );

        // when
        screenService.join(screening);

        // then
        assertThat(screening).isEqualTo(screenService.findScreening(1L));
    }

    @Test
    void findAllScreenings() {
        // given
        screenService.join(new Screening(
                1L,
                2L,
                LocalDateTime.of(2025, 4, 1, 10, 0),
                LocalDateTime.of(2025, 4, 1, 12, 0)
        ));
        screenService.join(new Screening(
                2L,
                3L,
                LocalDateTime.of(2025, 4, 1, 13, 0),
                LocalDateTime.of(2025, 4, 1, 15, 0)
        ));

        // when
        List<Screening> screenings = screenService.findAllScreenings();

        // then
        assertThat(screenings).hasSize(2);
    }

    @Test
    void deleteScreening() {
        // given
        screenService.join(new Screening(
                1L,
                2L,
                LocalDateTime.of(2025, 4, 1, 9, 0),
                LocalDateTime.of(2025, 4, 1, 11, 0)
        ));

        // when
        screenService.deleteScreening(1L);
        Screening screening = screenService.findScreening(1L);

        // then
        assertThat(screening).isNull();
    }
}