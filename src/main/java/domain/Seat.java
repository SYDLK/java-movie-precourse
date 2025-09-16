package domain;

import java.time.LocalDateTime;

public class Seat {
    private Long id;
    private String row;
    private int col;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;
    private int price;

    // 외래키
    private Long screeningId;

    public Seat(Long id, String row, int col, int status, int price, Long screeningId) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = status;
        this.price = price;
        this.screeningId = screeningId;
    }

    public Long getId() {
        return id;
    }

    public String getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row='" + row + '\'' +
                ", col=" + col +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                ", price=" + price +
                ", screeningId=" + screeningId +
                '}';
    }
}
