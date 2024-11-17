import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's the reminder?");
        String title = scanner.nextLine();

        System.out.println("Time should be in 24H format");
        System.out.println("When should the reminder be? (Format: yyyy-MM-dd HH:mm)");
        String dateTimeInput = scanner.nextLine();

        // Parsing the input string into LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime reminderTime;
        try {
            reminderTime = LocalDateTime.parse(dateTimeInput, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date-time format. Please use 'yyyy-MM-dd HH:mm'.");
            scanner.close();
            return;
        }

        Task reminder = new Task(title, reminderTime);
        System.out.println("Reminder set for: " + reminder.getTime());

        reminderService(reminder);
        scanner.close();

    }

    static void reminderService(Task reminder) {
        System.out.println("Current time: " + LocalDateTime.now());
        System.out.println("Reminder time: " + reminder.getTime());

        // Calculate the delay in seconds
        long delayInSeconds = java.time.Duration.between(LocalDateTime.now(), reminder.getTime()).getSeconds();

        if (delayInSeconds > 0) {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                System.out.println("Reminder: " + reminder.getTitle());
                scheduler.shutdown();
            }, delayInSeconds, TimeUnit.SECONDS);
        } else {
            System.out.println("The specified time has already passed!");
        }
    }

}
