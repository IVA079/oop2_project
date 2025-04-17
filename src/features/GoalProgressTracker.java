package features;

import utils.ConsoleColors;

public class GoalProgressTracker {

    public static void showProgress() {
        int calorieGoal = HealthGoalManager.getCalorieGoal();
        int waterGoal = HealthGoalManager.getWaterGoal();
        double sleepGoal = HealthGoalManager.getSleepGoal();

        int calories = MealManager.getTotalCalories();
        int water = WaterTracker.getWaterCount();
        double sleep = SleepTracker.getLastSleep();

        System.out.println(ConsoleColors.BLUE + "\n📈 Daily Progress Report:");

        System.out.println("🔥 Calories: " + calories + " / " + calorieGoal + " → " +
                progressStatus(calories <= calorieGoal));

        System.out.println("💧 Water: " + water + " / " + waterGoal + " → " +
                progressStatus(water >= waterGoal));

        System.out.println("😴 Sleep: " + sleep + " / " + sleepGoal + " → " +
                progressStatus(sleep >= sleepGoal));

        System.out.println(ConsoleColors.RESET);
    }

    private static String progressStatus(boolean achieved) {
        return achieved
                ? ConsoleColors.GREEN + "✅ Goal Reached" + ConsoleColors.BLUE
                : ConsoleColors.RED + "❌ Not Yet" + ConsoleColors.BLUE;
    }
}
