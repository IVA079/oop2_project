package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class MoodTracker {

    private static String currentMood = "Not set";

    public static void logMood() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW + "How are you feeling today?");
        System.out.println("1. 😊 Happy");
        System.out.println("2. 😔 Sad");
        System.out.println("3. 😴 Tired");
        System.out.println("4. 😠 Angry");
        System.out.println("5. 😎 Motivated");
        System.out.print("Enter choice: " + ConsoleColors.RESET);

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> currentMood = "😊 Happy";
            case 2 -> currentMood = "😔 Sad";
            case 3 -> currentMood = "😴 Tired";
            case 4 -> currentMood = "😠 Angry";
            case 5 -> currentMood = "😎 Motivated";
            default -> System.out.println(ConsoleColors.RED + "❌ Invalid choice." + ConsoleColors.RESET);
        }

        System.out.println(ConsoleColors.GREEN + "🧠 Mood updated: " + currentMood + ConsoleColors.RESET);
    }

    public static String getMood() {
        return currentMood;
    }
}
