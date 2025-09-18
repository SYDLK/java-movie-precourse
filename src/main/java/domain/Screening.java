package domain;

import java.time.LocalDateTime;

public class Screening {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 외래키
    private Long movieId;

    // 상영 시간
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Screening(Long id, Long movieId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getMovieId() { return movieId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
}
