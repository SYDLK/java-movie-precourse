package domain;

import java.time.LocalDateTime;

public class Seat {
    private Long id;
    private String row;
    private int col;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private char status; // enum으로 S, A, B
    private boolean reserved;

    // 외래키
    private Long screeningId;

    public Seat(Long id, String row, int col, char status, Long screeningId) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = status;
        this.screeningId = screeningId;
        this.reserved = false;
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

    public Long getScreeningId() {
        return screeningId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve(){
        this.reserved = true;
    }

    public void cancelReserve(){
        this.reserved = false;
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
                ", reserved=" + reserved +
                ", screeningId=" + screeningId +
                '}';
    }
}
