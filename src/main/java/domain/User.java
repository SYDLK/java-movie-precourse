package domain;
import java.time.LocalDateTime;


public class User {

    private Long id;
    private String name;
    private int score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void usePoints(int amount){
        if(amount > score){
            throw new IllegalArgumentException("포인트 부족");
        }
        this.score = score - amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
