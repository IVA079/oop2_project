package features;

import utils.ConsoleColors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SleepTracker {

    private static final List<Double> sleepHoursList = new ArrayList<>();

    public static void addSleep() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Enter your sleep duration in hours: " + ConsoleColors.RESET);
        double hours = Double.parseDouble(scanner.nextLine());

        sleepHoursList.add(hours);

        if (hours < 6) {
            System.out.println(ConsoleColors.RED + "⚠️ Fatigue Alert: You slept less than 6 hours!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "✅ Sleep logged successfully!" + ConsoleColors.RESET);
        }
    }

    public static void viewSleepLog() {
        if (sleepHoursList.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No sleep records yet." + ConsoleColors.RESET);
            return;
        }

        System.out.println(ConsoleColors.PURPLE + "\n😴 Sleep Log:\n");

        String format = "| %-10s | %-12s |\n";
        System.out.println("+------------+--------------+");
        System.out.printf(format, "Day", "Sleep (hrs)");
        System.out.println("+------------+--------------+");

        for (int i = 0; i < sleepHoursList.size(); i++) {
            System.out.printf(format, "Day " + (i + 1), String.format("%.1f", sleepHoursList.get(i)));
        }

        System.out.println("+------------+--------------+" + ConsoleColors.RESET);
    }

    public static double getLastSleep() {
        if (sleepHoursList.isEmpty()) return 0;
        return sleepHoursList.get(sleepHoursList.size() - 1);
    }

    public static void clearSleepData() {
        sleepHoursList.clear();
    }
}
