package features;

import utils.ConsoleColors;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NutritionInfoManager {

    private static final Map<String, Map<String, Double>> nutritionData = new HashMap<>();

    public static void addNutritionInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Enter meal name to add nutrition info: " + ConsoleColors.RESET);
        String mealName = scanner.nextLine().trim().toLowerCase();

        Map<String, Double> nutrition = new HashMap<>();

        System.out.print("Protein (g): ");
        nutrition.put("Protein", Double.parseDouble(scanner.nextLine()));
        System.out.print("Carbs (g): ");
        nutrition.put("Carbs", Double.parseDouble(scanner.nextLine()));
        System.out.print("Fat (g): ");
        nutrition.put("Fat", Double.parseDouble(scanner.nextLine()));
        System.out.print("Fiber (g): ");
        nutrition.put("Fiber", Double.parseDouble(scanner.nextLine()));

        nutritionData.put(mealName, nutrition);
        System.out.println(ConsoleColors.GREEN + "✅ Nutrition info added for meal: " + mealName + ConsoleColors.RESET);
    }

    public static void viewNutritionInfo() {
        if (nutritionData.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No nutrition data found." + ConsoleColors.RESET);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleColors.YELLOW + "Enter meal name to view nutrition info: " + ConsoleColors.RESET);
        String name = scanner.nextLine().trim().toLowerCase();

        if (!nutritionData.containsKey(name)) {
            System.out.println(ConsoleColors.RED + "❌ No data found for meal: " + name + ConsoleColors.RESET);
            return;
        }

        Map<String, Double> info = nutritionData.get(name);

        System.out.println(ConsoleColors.PURPLE + "\n🧬 Nutrition Info for '" + name + "':\n");

        String format = "| %-10s | %-10s |\n";
        System.out.println("+------------+------------+");
        System.out.printf(format, "Nutrient", "Amount (g)");
        System.out.println("+------------+------------+");

        for (Map.Entry<String, Double> entry : info.entrySet()) {
            System.out.printf(format, entry.getKey(), entry.getValue());
        }

        System.out.println("+------------+------------+" + ConsoleColors.RESET);
    }
}
