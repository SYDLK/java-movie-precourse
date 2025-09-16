package domain;

import java.time.LocalDateTime;

public class Screening {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //외래키
    private Long movieId;

    public Screening(Long id, Long movieId) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.movieId = movieId;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getMovieId() {
        return movieId;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", movieId=" + movieId +
                '}';
    }
}
