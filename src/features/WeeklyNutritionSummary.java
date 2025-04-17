package features;

import utils.ConsoleColors;

public class WeeklyNutritionSummary {

    public static void showWeeklySummary() {
        int totalCalories = MealManager.getTotalCalories();
        int mealCount = MealManager.getMealCount();

        if (mealCount == 0) {
            System.out.println(ConsoleColors.RED + "🚫 No meal data to summarize." + ConsoleColors.RESET);
            return;
        }

        double avgCalories = (double) totalCalories / mealCount;

        System.out.println(ConsoleColors.BLUE + "\n📅 Weekly Nutrition Summary:");
        System.out.println("🍽️ Total Meals Logged: " + mealCount);
        System.out.println("🔥 Total Calories Consumed: " + totalCalories + " kcal");
        System.out.println("📊 Average Calories per Meal: " + String.format("%.2f", avgCalories) + " kcal" + ConsoleColors.RESET);

        if (avgCalories < 500) {
            System.out.println(ConsoleColors.GREEN + "✅ Balanced average. Keep it up!" + ConsoleColors.RESET);
        } else if (avgCalories <= 800) {
            System.out.println(ConsoleColors.YELLOW + "⚠️ Moderate intake. Watch portions." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "❌ High average! Consider healthier meals." + ConsoleColors.RESET);
        }
    }
}
