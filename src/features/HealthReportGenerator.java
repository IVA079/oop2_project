package features;

import utils.ConsoleColors;

public class HealthReportGenerator {

    public static void showDailyReport() {
        int mealCount = MealManager.getMealCount();
        int totalCalories = MealManager.getTotalCalories();
        int workoutCount = ExerciseManager.getWorkoutCount();
        int caloriesBurned = ExerciseManager.getTotalBurnedCalories();
        double lastSleep = SleepTracker.getLastSleep();
        int water = WaterTracker.getWaterCount();

        System.out.println(ConsoleColors.BG_LIGHT_BLUE + ConsoleColors.WHITE + "\n📊 Daily Health Report" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.CYAN + "🍽️ Meals: " + mealCount);
        System.out.println("🔥 Calories Consumed: " + totalCalories + " kcal");
        System.out.println("🏋️ Workouts: " + workoutCount);
        System.out.println("🔥 Calories Burned: " + caloriesBurned + " kcal");
        System.out.println("😴 Sleep Last Night: " + lastSleep + " hours");
        System.out.println("💧 Water Intake: " + water + "/8 glasses" + ConsoleColors.RESET);

        int net = totalCalories - caloriesBurned;
        if (net < 1500) {
            System.out.println(ConsoleColors.GREEN + "✅ Great! You maintained a healthy calorie balance." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "⚠️ Watch out! High calorie intake today." + ConsoleColors.RESET);
        }
    }
}
