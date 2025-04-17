package features;

import utils.ConsoleColors;

public class PrizeSystem {

    public static void checkPrizes() {
        int streak = StreakSystem.getCurrentStreak();
        int totalCalories = MealManager.getTotalCalories();
        int workouts = ExerciseManager.getWorkoutCount();

        boolean awarded = false;

        if (streak >= 7) {
            System.out.println(ConsoleColors.YELLOW + "🏆 Prize Unlocked: 7-Day Streak Hero!");
            awarded = true;
        }
        if (totalCalories >= 10000) {
            System.out.println(ConsoleColors.CYAN + "🏅 Prize Unlocked: Meal Master (10,000 kcal tracked)!");
            awarded = true;
        }
        if (workouts >= 20) {
            System.out.println(ConsoleColors.GREEN + "🎖️ Prize Unlocked: Workout Warrior (20 sessions)!");
            awarded = true;
        }

        if (!awarded) {
            System.out.println(ConsoleColors.RED + "📛 No new prizes yet. Keep going!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RESET);
        }
    }
}
