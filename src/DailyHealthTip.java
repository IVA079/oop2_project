package features;

import utils.ConsoleColors;
import java.util.Random;

public class DailyHealthTip {

    private static final String[] tips = {
            "🥦 Eat at least 5 portions of fruits and vegetables every day.",
            "💧 Drink a glass of water every hour to stay hydrated.",
            "🚶 Walk 30 minutes every day to improve heart health.",
            "🧘 Practice deep breathing or meditation for 5 minutes.",
            "😴 Aim for 7–9 hours of sleep each night.",
            "🍵 Replace sugary drinks with herbal tea or lemon water.",
            "🥗 Eat slowly to help with digestion and prevent overeating."
    };

    public static void showRandomTip() {
        int index = new Random().nextInt(tips.length);
        System.out.println(ConsoleColors.BLUE + "🧠 Health Tip of the Day: " + tips[index] + ConsoleColors.RESET);
    }
}
