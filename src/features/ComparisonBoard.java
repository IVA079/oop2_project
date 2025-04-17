package features;

import utils.ConsoleColors;
import java.util.ArrayList;
import java.util.List;

public class ComparisonBoard {

    static class UserStats {
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

    public static void showComparison() {
        List<UserStats> friends = new ArrayList<>();

        friends.add(new UserStats("Alice", 1200, 2, 6.5, 7, 4));
        friends.add(new UserStats("Bob", 1600, 1, 7.0, 5, 2));
        friends.add(new UserStats("Charlie", 1400, 3, 8.0, 8, 6));

        UserStats you = new UserStats("You",
                MealManager.getTotalCalories(),
                ExerciseManager.getWorkoutCount(),
                SleepTracker.getLastSleep(),
                WaterTracker.getWaterCount(),
                StreakSystem.getCurrentStreak()
        );

        System.out.println(ConsoleColors.PURPLE + "\n👥 Social Comparison Leaderboard:\n");

        System.out.printf("%-10s | %-9s | %-8s | %-6s | %-5s | %-6s\n", "Name", "Calories", "Workouts", "Sleep", "Water", "Streak");
        System.out.println("---------------------------------------------------------");

        for (UserStats u : friends) {
            System.out.printf("%-10s | %-9d | %-8d | %-6.1f | %-5d | %-6d\n",
                    u.name, u.calories, u.workouts, u.sleep, u.water, u.streak);
        }

        System.out.println(ConsoleColors.CYAN + "\n📊 Your Stats:");
        System.out.printf("%-10s | %-9d | %-8d | %-6.1f | %-5d | %-6d\n",
                you.name, you.calories, you.workouts, you.sleep, you.water, you.streak);
        System.out.println(ConsoleColors.RESET);
    }
}
