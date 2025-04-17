package features;

import utils.ConsoleColors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MealManager {

    public static class Meal {
        String name;
        int calories;
        List<String> ingredients;

        public Meal(String name, int calories, List<String> ingredients) {
            this.name = name;
            this.calories = calories;
            this.ingredients = ingredients;
        }
    }

    private static final List<Meal> meals = new ArrayList<>();

    public static void addMeal() {
        Scanner scanner = new Scanner(System.in);
        boolean adding = true;

        while (adding) {
            System.out.print(ConsoleColors.YELLOW + "Enter meal name: " + ConsoleColors.RESET);
            String name = scanner.nextLine();

            System.out.print(ConsoleColors.YELLOW + "Enter total calories: " + ConsoleColors.RESET);
            int calories = Integer.parseInt(scanner.nextLine());

            System.out.print(ConsoleColors.YELLOW + "Enter ingredients (comma-separated): " + ConsoleColors.RESET);
            String[] items = scanner.nextLine().split(",");
            List<String> ingredients = new ArrayList<>();
            for (String item : items) {
                ingredients.add(item.trim());
            }

            meals.add(new Meal(name, calories, ingredients));
            System.out.println(ConsoleColors.GREEN + "✅ Meal added successfully!" + ConsoleColors.RESET);

            System.out.print(ConsoleColors.YELLOW + "Do you want to add another meal? (Y/N): " + ConsoleColors.RESET);
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                adding = false;
            }
        }
    }

    public static void viewMeals() {
        if (meals.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No meals logged yet." + ConsoleColors.RESET);
            return;
        }

        System.out.println(ConsoleColors.PURPLE + "\n🍽️ Meal History:\n");

        String format = "| %-15s | %-10s | %-30s |\n";

        System.out.println("+-----------------+------------+--------------------------------+");
        System.out.printf(format, "Meal Name", "Calories", "Ingredients");
        System.out.println("+-----------------+------------+--------------------------------+");

        for (Meal meal : meals) {
            String ingredientList = String.join(", ", meal.ingredients);
            if (ingredientList.length() > 30) {
                ingredientList = ingredientList.substring(0, 27) + "...";
            }

            System.out.printf(format, meal.name, meal.calories, ingredientList);
        }

        System.out.println("+-----------------+------------+--------------------------------+" + ConsoleColors.RESET);
    }

    public static void updateMeal() {
        if (meals.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No meals to update." + ConsoleColors.RESET);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleColors.YELLOW + "Enter the name of the meal to update: " + ConsoleColors.RESET);
        String name = scanner.nextLine().trim();

        Meal mealToUpdate = null;
        for (Meal m : meals) {
            if (m.name.equalsIgnoreCase(name)) {
                mealToUpdate = m;
                break;
            }
        }

        if (mealToUpdate == null) {
            System.out.println(ConsoleColors.RED + "❌ Meal not found." + ConsoleColors.RESET);
            return;
        }

        System.out.print(ConsoleColors.YELLOW + "New meal name (leave blank to keep): " + ConsoleColors.RESET);
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            mealToUpdate.name = newName;
        }

        System.out.print(ConsoleColors.YELLOW + "New calories (or -1 to keep): " + ConsoleColors.RESET);
        int newCalories = Integer.parseInt(scanner.nextLine());
        if (newCalories != -1) {
            mealToUpdate.calories = newCalories;
        }

        System.out.print(ConsoleColors.YELLOW + "New ingredients (comma-separated, or blank to keep): " + ConsoleColors.RESET);
        String newIngredients = scanner.nextLine();
        if (!newIngredients.isEmpty()) {
            String[] items = newIngredients.split(",");
            List<String> updated = new ArrayList<>();
            for (String item : items) {
                updated.add(item.trim());
            }
            mealToUpdate.ingredients = updated;
        }

        System.out.println(ConsoleColors.GREEN + "✅ Meal updated successfully!" + ConsoleColors.RESET);
    }

    public static void removeMeal() {
        if (meals.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No meals to remove." + ConsoleColors.RESET);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleColors.YELLOW + "Enter meal name to remove: " + ConsoleColors.RESET);
        String name = scanner.nextLine().trim();

        boolean removed = meals.removeIf(meal -> meal.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println(ConsoleColors.GREEN + "✅ Meal '" + name + "' removed." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "❌ Meal not found." + ConsoleColors.RESET);
        }
    }

    public static int getTotalCalories() {
        int sum = 0;
        for (Meal m : meals) {
            sum += m.calories;
        }
        return sum;
    }

    public static int getMealCount() {
        return meals.size();
    }

    public static List<Meal> getAllMeals() {
        return new ArrayList<>(meals);
    }

    public static void clearMeals() {
        meals.clear();
    }
}
