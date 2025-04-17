package features;

import utils.ConsoleColors;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthySubstitutionRecommender {

    private static final Map<String, String> substitutions = new HashMap<>();

    static {
        substitutions.put("cola", "lemon water 🍋💧");
        substitutions.put("chips", "air-popped popcorn 🍿");
        substitutions.put("fried chicken", "grilled chicken 🍗");
        substitutions.put("white rice", "brown rice 🍚");
        substitutions.put("chocolate", "dark chocolate 🍫 (in moderation)");
        substitutions.put("ice cream", "frozen yogurt 🍦");
        substitutions.put("sugary cereal", "oats with fruits 🍓");
        substitutions.put("white bread", "whole grain bread 🍞");
    }

    public static void suggestSubstitution() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleColors.YELLOW + "Enter a food you'd like a healthy substitute for: " + ConsoleColors.RESET);
        String input = scanner.nextLine().trim().toLowerCase();

        if (substitutions.containsKey(input)) {
            System.out.println(ConsoleColors.GREEN + "✅ Try this instead: " + substitutions.get(input) + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "❌ Sorry, no substitution found for \"" + input + "\"." + ConsoleColors.RESET);
        }
    }
}
