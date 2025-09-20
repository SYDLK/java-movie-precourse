import java.time.LocalDateTime;

public class Movie {
    private long id;
    private String title;
    private int price;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Movie(long id, String title, int price, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
