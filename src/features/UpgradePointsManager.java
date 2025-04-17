package features;

import utils.ConsoleColors;

public class UpgradePointsManager {

    private static int points = 0;

    public static void rewardPoints(String task) {
        switch (task.toLowerCase()) {
            case "meal" -> points += 10;
            case "workout" -> points += 15;
            case "water" -> points += 5;
            case "sleep" -> points += 8;
        }
        System.out.println(ConsoleColors.GREEN + "⚡ Points earned! Current total: " + points + ConsoleColors.RESET);
    }

    public static void showUpgrades() {
        System.out.println(ConsoleColors.BLUE + "\n🛍️ Upgrade Menu:");
        System.out.println("1. 💡 Health Tip Pack (50 pts)");
        System.out.println("2. 🥗 Premium Meal Suggestion (80 pts)");
        System.out.println("3. 🏅 Custom Badge (100 pts)");
        System.out.println("Total Points: " + points + ConsoleColors.RESET);
    }

    public static void redeemUpgrade(int option) {
        switch (option) {
            case 1 -> {
                if (points >= 50) {
                    points -= 50;
                    System.out.println(ConsoleColors.CYAN + "💡 You unlocked bonus health tips!" + ConsoleColors.RESET);
                } else {
                    showInsufficient();
                }
            }
            case 2 -> {
                if (points >= 80) {
                    points -= 80;
                    System.out.println(ConsoleColors.CYAN + "🥗 You unlocked premium meal suggestions!" + ConsoleColors.RESET);
                } else {
                    showInsufficient();
                }
            }
            case 3 -> {
                if (points >= 100) {
                    points -= 100;
                    System.out.println(ConsoleColors.CYAN + "🏅 You unlocked a custom health badge!" + ConsoleColors.RESET);
                } else {
                    showInsufficient();
                }
            }
            default -> System.out.println(ConsoleColors.RED + "❌ Invalid option." + ConsoleColors.RESET);
        }
    }

    private static void showInsufficient() {
        System.out.println(ConsoleColors.RED + "❌ Not enough points. Keep tracking to earn more!" + ConsoleColors.RESET);
    }

    public static int getPoints() {
        return points;
    }
}
