package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class MealSearchEngine {

    public static void searchMeal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW + "Search by:");
        System.out.println("1. Meal Name");
        System.out.println("2. Ingredient");
        System.out.print("Enter choice: " + ConsoleColors.RESET);
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print(ConsoleColors.YELLOW + "Enter search keyword: " + ConsoleColors.RESET);
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (MealManager.Meal meal : MealManager.getAllMeals()) {
            if (choice == 1 && meal.name.toLowerCase().contains(keyword)) {
                System.out.println(meal);
                System.out.println("-----------------------------");
                found = true;
            } else if (choice == 2) {
                for (String ingredient : meal.ingredients) {
                    if (ingredient.toLowerCase().contains(keyword)) {
                        System.out.println(meal);
                        System.out.println("-----------------------------");
                        found = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            System.out.println(ConsoleColors.RED + "❌ No matching meals found." + ConsoleColors.RESET);
        }
    }
}
