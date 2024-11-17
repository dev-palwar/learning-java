import models.Task;
import services.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

        Utils.reminderService(reminder);
        scanner.close();
    }
}
