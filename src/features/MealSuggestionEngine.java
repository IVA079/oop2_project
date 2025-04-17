package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class MealSuggestionEngine {

    public static void suggestMealPlan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW + "Select your preferred diet type:");
        System.out.println("1. Vegetarian 🥗");
        System.out.println("2. Keto 🥩");
        System.out.println("3. High Protein 💪");
        System.out.println("4. Balanced 🍱");
        System.out.print("Enter choice: " + ConsoleColors.RESET);

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> suggestVegetarian();
            case 2 -> suggestKeto();
            case 3 -> suggestHighProtein();
            case 4 -> suggestBalanced();
            default -> System.out.println(ConsoleColors.RED + "❌ Invalid choice." + ConsoleColors.RESET);
        }
    }

    private static void suggestVegetarian() {
        System.out.println(ConsoleColors.GREEN + "\n🥗 Vegetarian Meal Plan:");
        System.out.println("- Breakfast: Oatmeal with banana & almonds");
        System.out.println("- Lunch: Lentil curry with brown rice");
        System.out.println("- Dinner: Grilled tofu & mixed veggies" + ConsoleColors.RESET);
    }

    private static void suggestKeto() {
        System.out.println(ConsoleColors.GREEN + "\n🥩 Keto Meal Plan:");
        System.out.println("- Breakfast: Scrambled eggs with avocado");
        System.out.println("- Lunch: Chicken salad with olive oil");
        System.out.println("- Dinner: Grilled salmon & steamed spinach" + ConsoleColors.RESET);
    }

    private static void suggestHighProtein() {
        System.out.println(ConsoleColors.GREEN + "\n💪 High Protein Meal Plan:");
        System.out.println("- Breakfast: Greek yogurt with berries");
        System.out.println("- Lunch: Turkey wrap with quinoa");
        System.out.println("- Dinner: Grilled chicken breast with beans" + ConsoleColors.RESET);
    }

    private static void suggestBalanced() {
        System.out.println(ConsoleColors.GREEN + "\n🍱 Balanced Meal Plan:");
        System.out.println("- Breakfast: Whole-grain toast with egg");
        System.out.println("- Lunch: Rice, veggies, and fish");
        System.out.println("- Dinner: Soup, salad, and fruits" + ConsoleColors.RESET);
    }
}
