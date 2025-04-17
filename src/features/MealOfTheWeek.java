package features;

import utils.ConsoleColors;
import java.util.List;

public class MealOfTheWeek {

    public static void highlightMeal() {
        List<MealManager.Meal> meals = MealManager.getAllMeals();

        if (meals.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No meals logged to choose from." + ConsoleColors.RESET);
            return;
        }

        MealManager.Meal bestMeal = meals.get(0);
        for (MealManager.Meal meal : meals) {
            if (meal.calories < bestMeal.calories) {
                bestMeal = meal;
            }
        }

        System.out.println(ConsoleColors.PURPLE + "\n🏅 Meal of the Week:");
        System.out.println(bestMeal);
        System.out.println("🥇 This meal has the lowest calories: " + bestMeal.calories + " kcal" + ConsoleColors.RESET);
    }
}
