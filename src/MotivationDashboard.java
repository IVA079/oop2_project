package features;

import utils.ConsoleColors;
import java.time.LocalDate;
import java.util.Random;

public class MotivationDashboard {

    private static final String[] quotes = {
            "Push yourself, because no one else is going to do it for you.",
            "The only bad workout is the one you didn't do.",
            "Take care of your body. It’s the only place you have to live.",
            "Your health is an investment, not an expense.",
            "Discipline is choosing what you want most over what you want now."
    };

    public static void showMotivationalDashboard() {
        System.out.println(ConsoleColors.BG_PINK + ConsoleColors.WHITE + "💚 Daily Motivation & Health Dashboard 💚" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "📅 Date: " + LocalDate.now() + ConsoleColors.RESET);

        int meals = MealManager.getMealCount();
        int calories = MealManager.getTotalCalories();
        int workouts = ExerciseManager.getWorkoutCount();
        double sleep = SleepTracker.getLastSleep();
        int water = WaterTracker.getWaterCount();
        String mood = MoodTracker.getMood();
        int streak = StreakSystem.getCurrentStreak();

        System.out.println(ConsoleColors.CYAN + "\n🍽️ Meals: " + meals);
        System.out.println("🔥 Calories: " + calories);
        System.out.println("🏋️ Workouts: " + workouts);
        System.out.println("💧 Water: " + water + " glasses");
        System.out.println("😴 Sleep: " + sleep + " hrs");
        System.out.println("🧠 Mood: " + mood);
        System.out.println("🎯 Streak: " + streak + " days" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "\n💬 Motivation of the Day:");
        System.out.println("✨ \"" + quotes[new Random().nextInt(quotes.length)] + "\"" + ConsoleColors.RESET);
    }
}
