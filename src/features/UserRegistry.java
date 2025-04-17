package features;

import utils.ConsoleColors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistry {

    public static class UserStats {
        String name;
        int calories;
        int workouts;
        double sleep;
        int water;
        int streak;

        public UserStats(String name, int calories, int workouts, double sleep, int water, int streak) {
            this.name = name;
            this.calories = calories;
            this.workouts = workouts;
            this.sleep = sleep;
            this.water = water;
            this.streak = streak;
        }
    }

    private static final List<UserStats> allUsers = new ArrayList<>();

    public static void registerCurrentUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleColors.YELLOW + "Enter your name: " + ConsoleColors.RESET);
        String name = scanner.nextLine().trim();

        int calories = MealManager.getTotalCalories();
        int workouts = ExerciseManager.getWorkoutCount();
        double sleep = SleepTracker.getLastSleep();
        int water = WaterTracker.getWaterCount();
        int streak = StreakSystem.getCurrentStreak();

        allUsers.add(new UserStats(name, calories, workouts, sleep, water, streak));

        System.out.println(ConsoleColors.GREEN + "✅ Registered! You will appear in the comparison." + ConsoleColors.RESET);
    }

    public static void showAllUsersComparison() {
        if (allUsers.isEmpty()) {
            System.out.println(ConsoleColors.RED + "❌ No users registered yet." + ConsoleColors.RESET);
            return;
        }

        System.out.println(ConsoleColors.PURPLE + "\n👥 All Registered Users Comparison:\n");
        System.out.printf("%-10s | %-9s | %-8s | %-6s | %-5s | %-6s\n", "Name", "Calories", "Workouts", "Sleep", "Water", "Streak");
        System.out.println("----------------------------------------------------------");

        for (UserStats u : allUsers) {
            System.out.printf("%-10s | %-9d | %-8d | %-6.1f | %-5d | %-6d\n",
                    u.name, u.calories, u.workouts, u.sleep, u.water, u.streak);
        }

        System.out.println(ConsoleColors.RESET);
    }
}
