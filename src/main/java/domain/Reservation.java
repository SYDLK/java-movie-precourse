package domain;

import java.time.LocalDateTime;

public class Reservation {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 외래키
    private Long userId;
    private Long seatId;

    public Reservation(Long id, Long userId, Long seatId) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.userId = userId;
        this.seatId = seatId;
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

    public Long getUserId() {
        return userId;
    }

    public Long getSeatId() {
        return seatId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userId=" + userId +
                ", seatId=" + seatId +
                '}';
    }
}
