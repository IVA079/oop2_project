package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class HealthGoalManager {

    private static int calorieGoal = 1800;
    private static int waterGoal = 8;
    private static double sleepGoal = 8.0;

    public static void setGoals() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Set your daily calorie goal (kcal): " + ConsoleColors.RESET);
        calorieGoal = Integer.parseInt(scanner.nextLine());

        System.out.print(ConsoleColors.YELLOW + "Set your daily water goal (glasses): " + ConsoleColors.RESET);
        waterGoal = Integer.parseInt(scanner.nextLine());

        System.out.print(ConsoleColors.YELLOW + "Set your daily sleep goal (hours): " + ConsoleColors.RESET);
        sleepGoal = Double.parseDouble(scanner.nextLine());

        System.out.println(ConsoleColors.GREEN + "✅ Health goals updated successfully!" + ConsoleColors.RESET);
    }

    public static int getCalorieGoal() {
        return calorieGoal;
    }

    public static int getWaterGoal() {
        return waterGoal;
    }

    public static double getSleepGoal() {
        return sleepGoal;
    }

    public static void viewGoals() {
        System.out.println(ConsoleColors.PURPLE + "\n🎯 Your Current Health Goals:\n");

        String format = "| %-12s | %-15s |\n";
        System.out.println("+--------------+-----------------+");
        System.out.printf(format, "Goal Type", "Target");
        System.out.println("+--------------+-----------------+");

        System.out.printf(format, "Calories", calorieGoal + " kcal");
        System.out.printf(format, "Water", waterGoal + " glasses");
        System.out.printf(format, "Sleep", String.format("%.1f", sleepGoal) + " hrs");

        System.out.println("+--------------+-----------------+" + ConsoleColors.RESET);
    }
}
