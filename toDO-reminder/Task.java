import java.time.LocalDateTime;

public class Task {
    private String title;
    private LocalDateTime time;

    public Task(String title, LocalDateTime time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getTime() {
        return this.time;
    }
}
