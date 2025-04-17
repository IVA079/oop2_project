package features;

import utils.ConsoleColors;
import java.util.Random;

public class MotivationQuote {

    private static final String[] quotes = {
            "💪 Health is the greatest wealth.",
            "🌱 Small changes make big results.",
            "🏃‍♂️ A healthy outside starts from the inside.",
            "🍎 You are what you eat. So don’t be fast, cheap, easy, or fake.",
            "⏳ Take care of your body. It’s the only place you have to live.",
            "🔥 Don’t wish for it. Work for it."
    };

    public static void showRandomQuote() {
        int index = new Random().nextInt(quotes.length);
        System.out.println(ConsoleColors.YELLOW + "💬 Motivation: " + quotes[index] + ConsoleColors.RESET);
    }
}
