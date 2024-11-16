package todoManager;

public class Task {
    private String title;
    private boolean isCompleted;

    public Task(String title, boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return title + " (Completed: " + (isCompleted ? "Yes" : "No") + ")";
    }
}
