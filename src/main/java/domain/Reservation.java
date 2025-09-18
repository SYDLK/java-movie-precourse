package domain;

import java.time.LocalDateTime;

public class Reservation {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int price;
    private PaymentType paymentType;
    private int finalPrice;

    // 외래키
    private Long userId;
    private Long seatId;
    private Long screeningId;

    public Reservation(Long id, Long userId, Long seatId, Long screeningId,
                       int price, PaymentType paymentType) {
        this.id = id;
        this.userId = userId;
        this.seatId = seatId;
        this.screeningId = screeningId;
        this.price = price;
        this.paymentType = paymentType;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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

    public int getPrice() {
        return price;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setFianlPrice(int finalprice) {
        this.finalPrice = finalprice;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", price=" + price +
                ", paymentType=" + paymentType +
                ", finalPrice=" + finalPrice +
                ", userId=" + userId +
                ", seatId=" + seatId +
                ", screeningId=" + screeningId +
                '}';
    }
}
