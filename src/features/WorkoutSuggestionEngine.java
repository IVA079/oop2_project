package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class WorkoutSuggestionEngine {

    public static void suggestWorkout() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW + "Select your fitness level:");
        System.out.println("1. Beginner 🐣");
        System.out.println("2. Intermediate 🏃");
        System.out.println("3. Advanced 🏆");
        System.out.print("Enter choice: " + ConsoleColors.RESET);

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> suggestBeginner();
            case 2 -> suggestIntermediate();
            case 3 -> suggestAdvanced();
            default -> System.out.println(ConsoleColors.RED + "❌ Invalid choice." + ConsoleColors.RESET);
        }
    }

    private static void suggestBeginner() {
        System.out.println(ConsoleColors.GREEN + "\n🐣 Beginner Workout Plan:");
        System.out.println("- 10 min walk");
        System.out.println("- 10 bodyweight squats");
        System.out.println("- 5 push-ups");
        System.out.println("- 10 knee raises" + ConsoleColors.RESET);
    }

    private static void suggestIntermediate() {
        System.out.println(ConsoleColors.GREEN + "\n🏃 Intermediate Workout Plan:");
        System.out.println("- 20 min jog");
        System.out.println("- 3 sets of 15 squats");
        System.out.println("- 2 sets of 10 push-ups");
        System.out.println("- 20 sit-ups" + ConsoleColors.RESET);
    }

    private static void suggestAdvanced() {
        System.out.println(ConsoleColors.GREEN + "\n🏆 Advanced Workout Plan:");
        System.out.println("- 30 min run");
        System.out.println("- 4 sets of 20 burpees");
        System.out.println("- 3 sets of 15 push-ups");
        System.out.println("- 30 mountain climbers" + ConsoleColors.RESET);
    }
}
