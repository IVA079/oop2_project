package features;

import utils.ConsoleColors;

public class CalorieCalculator {

    public static void showNetCalories() {
        int consumed = MealManager.getTotalCalories();
        int burned = ExerciseManager.getTotalBurnedCalories();
        int net = consumed - burned;

        System.out.println(ConsoleColors.PURPLE + "\n🔥 Calorie Summary:");
        System.out.println("🍽️ Total Calories Consumed: " + consumed);
        System.out.println("🏋️ Calories Burned: " + burned);
        System.out.println("📊 Net Calories: " + net);

        if (net < 1500) {
            System.out.println(ConsoleColors.GREEN + "✅ Great job! You're in a healthy range." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "⚠️ Consider burning more or reducing intake." + ConsoleColors.RESET);
        }
    }
}
