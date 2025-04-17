package features;

import utils.ConsoleColors;
import java.time.LocalDate;
import java.util.*;

public class FoodExpiryReminder {

    private static final Map<String, LocalDate> foodExpiryMap = new HashMap<>();

    public static void addFood() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Enter food name: " + ConsoleColors.RESET);
        String name = scanner.nextLine().trim();

        System.out.print(ConsoleColors.YELLOW + "Enter expiry date (YYYY-MM-DD): " + ConsoleColors.RESET);
        LocalDate expiry = LocalDate.parse(scanner.nextLine().trim());

        foodExpiryMap.put(name.toLowerCase(), expiry);
        System.out.println(ConsoleColors.GREEN + "✅ Food added with expiry: " + expiry + ConsoleColors.RESET);
    }

    public static void showExpiryWarnings() {
        if (foodExpiryMap.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No food data available." + ConsoleColors.RESET);
            return;
        }

        LocalDate today = LocalDate.now();
        System.out.println(ConsoleColors.PURPLE + "\n⏳ Food Expiry Check:");

        boolean anyWarning = false;

        for (Map.Entry<String, LocalDate> entry : foodExpiryMap.entrySet()) {
            String food = entry.getKey();
            LocalDate expiry = entry.getValue();

            if (expiry.isBefore(today)) {
                System.out.println(ConsoleColors.RED + "❌ " + food + " has expired on " + expiry + ConsoleColors.RESET);
                anyWarning = true;
            } else if (!expiry.isAfter(today.plusDays(2))) {
                System.out.println(ConsoleColors.YELLOW + "⚠️ " + food + " is expiring soon on " + expiry + ConsoleColors.RESET);
                anyWarning = true;
            }
        }

        if (!anyWarning) {
            System.out.println(ConsoleColors.GREEN + "✅ All foods are safe for now!" + ConsoleColors.RESET);
        }
    }
}
