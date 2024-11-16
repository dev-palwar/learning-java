package todoManager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getPendingTasks() {
        ArrayList<Task> pendingTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }

        return pendingTasks;
    }

    public void markCompleted(int index) {
        for (int i = 0; i < tasks.size(); i++) {
            if (i == index && !tasks.get(i).isCompleted()) {
                tasks.get(i).markCompleted();
            } else {
                System.out.println("Task already completed!");
            }
        }
    }
}
