package services;

import java.io.IOException;

public class SystemNotifier {
    public void sendNotification(String title, String message) {
        try {
            String command = String.format("notify-send \"%s\" \"%s\"", title, message);
            System.out.println("Executing command: " + command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to send notification: " + e.getMessage());
        }
    }
}
