package todoManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yo!");

        while (true) {
            System.out
                    .println("\n1. Add Task\n2. View Tasks\n3. View Pending Tasks\n4. Mark Task as Completed\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTaskToTaskManager(taskManager, scanner);
                    break;
                case 2:
                    getAllTasksFromTaskManager(taskManager);
                    break;
                case 3:
                    getPendingTasksFromTaskManager(taskManager);
                    break;
                case 4:
                    handleTaskStatus(taskManager, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void handleTaskStatus(TaskManager taskManager, Scanner scanner) {
        getPendingTasksFromTaskManager(taskManager);
        System.out.println("Which task?");
        int index = scanner.nextInt();

        taskManager.markCompleted(index - 1);
    }

    static void getPendingTasksFromTaskManager(TaskManager taskManager) {
        System.out.println("Pending Tasks:");
        int count = 1;
        for (Task task : taskManager.getPendingTasks()) {
            System.out.println(count++ + ". " + task);
        }
    }

    static void getAllTasksFromTaskManager(TaskManager taskManager) {
        System.out.println("All Tasks:");
        int count = 1;
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(count++ + ". " + task);
        }
    }

    static void addTaskToTaskManager(TaskManager taskManager, Scanner scanner) {
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        taskManager.addTask(new Task(title, false));
        System.out.println("Task added!");
    }
}
