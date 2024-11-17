package services;

import models.Task;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Utils {
    public static void reminderService(Task reminder) {
        long delayInSeconds = java.time.Duration.between(LocalDateTime.now(), reminder.getTime()).getSeconds();

        if (delayInSeconds > 0) {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                String notificationTitle = "Task Reminder";
                String notificationMessage = reminder.getTitle();

                SystemNotifier notifier = new SystemNotifier();
                notifier.sendNotification(notificationTitle, notificationMessage);

                System.out.println("Reminder: " + reminder.getTitle());
                scheduler.shutdown();
            }, delayInSeconds, TimeUnit.SECONDS);

            System.out.println("Reminder set for: " + reminder.getTime());
        } else {
            System.out.println("The specified time has already passed!");
        }
    }
}
