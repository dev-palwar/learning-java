package numberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Guess a number between 1 - 100");
        System.out.println("Enter negative number to exit");

        Random random = new Random();
        int originalNumber = random.nextInt(99);

        int numberOfEfforts = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int number = scanner.nextInt();
                numberOfEfforts++;
                if (number < 0) {
                    System.exit(0);
                }
                if (number > originalNumber) {
                    System.out.println("jyada");
                } else if (number < originalNumber) {
                    System.out.println("kam");
                } else if (number == originalNumber) {
                    System.out.println("haan yahi hai");
                    System.out.println("Number of efforts: " + numberOfEfforts);
                    System.exit(0);
                }
            }
        }

    }
}