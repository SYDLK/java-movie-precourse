package service;

import domain.Movie;
import domain.Screening;
import domain.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MemoryMovieRepository;
import repository.MemoryScreenRepository;
import repository.MemorySeatRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeatServiceTest {
    SeatService seatService;
    ScreenService screenService;
    MovieService movieService;

    @BeforeEach
    void setUp() {
        seatService = new SeatServiceImpl(new MemorySeatRepository());
        screenService = new ScreenServiceImpl(new MemoryScreenRepository());
        movieService = new MovieServiceImpl(new MemoryMovieRepository());
    }


    @Test
    void join() {
        // given
        Movie movie = new Movie(2L, "바람의 나라", LocalDate.of(2025,4,1), LocalDate.of(2025,4,2));
        movieService.join(movie);
        Screening screening = new Screening(5L, movie.getId());
        screenService.join(screening);


        Seat seat = new Seat(
                6L,
                "a",
                1,
                's',
                screening.getId()
        );


        // when
        seat.reserve();
        seatService.join(seat);
        Seat seat0 = seatService.findSeat(6L);
        Screening screen = screenService.findScreening(screening.getId());

        // then
        assertThat(seat0.getId()).isEqualTo(6L);
        assertThat(screen.getId()).isEqualTo(5L);
        System.out.println(seat0);
    }

    @Test
    void findSeat() {
        // given
        seatService.join(new Seat(
                6L,
                "a",
                1,
                's',
                5L
        ));

        // when
        Seat seat = seatService.findSeat(6L);


        // then
        assertThat(seat).isEqualTo(seatService.findSeat(6L));
    }

    @Test
    void findAllSeats() {
        // given
        seatService.join(new Seat(
                6L,
                "a",
                1,
                's',
                5L
        ));

        seatService.join(new Seat(
                4L,
                "a",
                1,
                'a',
                3L
        ));


        // when
        List<Seat> seats = seatService.findAllSeats();


        // then
        assertThat(seats).hasSize(2);
    }

    @Test
    void deleteSeat() {
        // given
        seatService.join(new Seat(
                6L,
                "a",
                1,
                's',
                5L
        ));

        // when
        seatService.deleteSeat(6L);

        // then
        assertThat(seatService.findSeat(6L)).isNull();
    }

    @Test
    void CheckSeatAvailable(){
        // given
        seatService.join(new Seat(
                6L,
                "a",
                1,
                's',
                5L
        ));

        // when
        String before = seatService.CheckSeatAvailable(6L);

        Seat seat0 = seatService.findSeat(6L);
        seat0.reserve();

        String after = seatService.CheckSeatAvailable(6L);

        seatService.deleteSeat(6L);
        String noseat = seatService.CheckSeatAvailable(6L);


        // then
        assertThat(before).isEqualTo("예약 가능합니다.");
        assertThat(after).isEqualTo("예약 불가능합니다.");
        assertThat(noseat).isEqualTo("좌석이 존재하지 않습니다.");
    }

    @Test
    void findSeatByScreeningId() {
        // given
        seatService.join(new Seat(
                6L,
                "a",
                1,
                's',
                5L
        ));

        seatService.join(new Seat(
                4L,
                "b",
                5,
                'a',
                5L
        ));

        seatService.join(new Seat(
                2L,
                "b",
                5,
                'a',
                6L
        ));

        // when
        List<Seat> seats = seatService.findSeatsByScreening(5L);

        // then
        assertThat(seats).hasSize(2);
    }

}