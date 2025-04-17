package features;

import utils.ConsoleColors;
import java.time.LocalDate;

public class Dashboard {
    public static void showDashboard(int meals, int calories, int workouts, double sleep, int water, String mood, int streak) {
        System.out.println(ConsoleColors.BG_PINK + ConsoleColors.WHITE + "💚 Welcome to Savour the Flavours of Health 💚" + ConsoleColors.RESET);
        System.out.println();
        System.out.println(ConsoleColors.YELLOW + "📅 Date: " + LocalDate.now() + ConsoleColors.RESET);

        System.out.println(ConsoleColors.CYAN + "\n🍽️ Meals Logged Today: " + meals);
        System.out.println("🔥 Calories Consumed: " + calories + " kcal");
        System.out.println("💪 Workouts Done: " + workouts);
        System.out.println("🛌 Sleep: " + sleep + " hours");
        System.out.println("💧 Water Intake: " + water + "/8 glasses");
        System.out.println("🧠 Mood: " + mood);
        System.out.println("🎯 Streak: " + streak + " days ✔" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.PURPLE + "\n📈 Weekly Comparison:");
        System.out.println("Calories ⬆️ | Sleep ⬇️ | Workouts ⬆️" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "\n🌟 Tip of the Day: Drink water before every meal to stay full & hydrated!");
        System.out.println("💬 Motivation: \"Health is the greatest wealth.\"" + ConsoleColors.RESET);
    }
}
