package features;

import utils.ConsoleColors;

public class StreakSystem {

    private static int currentStreak = 0;
    private static int lastDayMeal = 0;
    private static int lastDayWater = 0;
    private static int lastDaySleep = 0;
    private static int lastDayWorkout = 0;

    public static void evaluateStreak() {
        boolean meals = MealManager.getMealCount() >= 1;
        boolean water = WaterTracker.getWaterCount() >= 5;
        boolean sleep = SleepTracker.getLastSleep() >= 6;
        boolean workout = ExerciseManager.getWorkoutCount() >= 1;

        if (meals && water && sleep && workout) {
            currentStreak++;
            System.out.println(ConsoleColors.GREEN + "🔥 Streak increased! Current: " + currentStreak + " days" + ConsoleColors.RESET);
        } else {
            currentStreak = 0;
            System.out.println(ConsoleColors.RED + "⚠️ Healthy day incomplete. Streak reset." + ConsoleColors.RESET);
        }
    }

    public static void showStreak() {
        System.out.println(ConsoleColors.BLUE + "🎯 Current Healthy Streak: " + currentStreak + " days" + ConsoleColors.RESET);
    }

    public static int getCurrentStreak() {
        return currentStreak;
    }
}
