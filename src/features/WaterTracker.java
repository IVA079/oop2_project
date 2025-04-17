package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class WaterTracker {

    private static int totalGlasses = 0;

    public static void addWater() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Enter number of glasses of water you drank: " + ConsoleColors.RESET);
        int glasses = Integer.parseInt(scanner.nextLine());

        totalGlasses += glasses;

        if (glasses < 5) {
            System.out.println(ConsoleColors.RED + "💧 Warning: You should drink more water!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "✅ Water intake logged!" + ConsoleColors.RESET);
        }
    }

    public static void viewWaterStatus() {
        System.out.println(ConsoleColors.PURPLE + "\n🚰 Daily Water Intake Summary:\n");

        String format = "| %-20s | %-15s |\n";
        System.out.println("+----------------------+-----------------+");
        System.out.printf(format, "Metric", "Value");
        System.out.println("+----------------------+-----------------+");
        System.out.printf(format, "Glasses of Water", totalGlasses);
        System.out.println("+----------------------+-----------------+" + ConsoleColors.RESET);
    }

    public static int getWaterCount() {
        return totalGlasses;
    }

    public static void clearWaterData() {
        totalGlasses = 0;
    }
}
