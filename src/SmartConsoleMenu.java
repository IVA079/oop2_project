import java.util.*;
import features.*;
import features.MotivationDashboard;

public class SmartConsoleMenu {

    static class Feature {
        String label;
        Runnable action;

        Feature(String label, Runnable action) {
            this.label = label;
            this.action = action;
        }
    }

    public static void main(String[] args) {
        new SmartConsoleMenu().run();
    }

    public void run() {
        List<Feature> features = List.of(
                new Feature("🍽️ Add Meal", MealManager::addMeal),
                new Feature("📋 View Meals", MealManager::viewMeals),
                new Feature("✏️ Update Meal", MealManager::updateMeal),
                new Feature("🗑️ Remove Meal", MealManager::removeMeal),
                new Feature("🛌 Add Sleep", SleepTracker::addSleep),
                new Feature("🛌 View Sleep Log", SleepTracker::viewSleepLog),
                new Feature("💧 Add Water", WaterTracker::addWater),
                new Feature("💧 View Water Log", WaterTracker::viewWaterStatus),
                new Feature("🏋️ Add Exercise", ExerciseManager::addExercise),
                new Feature("🏋️ View Exercises", ExerciseManager::viewExercises),
                new Feature("📊 View Net Calories", CalorieCalculator::showNetCalories),
                new Feature("📊 Weekly Summary", WeeklyNutritionSummary::showWeeklySummary),
                new Feature("📊 Export Report", ReportExporter::exportDailyReport),
                new Feature("🧠 Log Mood", MoodTracker::logMood),
                new Feature("🧠 Motivation Tip", MotivationDashboard::showMotivationalDashboard),
                new Feature("🧠 Health Quiz", HealthQuizAndTips::showRandom),
                new Feature("⚖️ BMI Calculator", BMICalculator::calculateBMI),
                new Feature("🥦 Healthy Substitution", HealthySubstitutionRecommender::suggestSubstitution),
                new Feature("🥇 Meal of the Week", MealOfTheWeek::highlightMeal),
                new Feature("🧾 Reset Data", DataResetter::resetAllData),
                new Feature("🧑 Register User", UserRegistry::registerCurrentUser),
                new Feature("📊 Compare Users", UserRegistry::showAllUsersComparison),
                new Feature("🏅 Check Prizes", PrizeSystem::checkPrizes),
                new Feature("🎁 Redeem Points", () -> {
                    UpgradePointsManager.showUpgrades();
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter option (1-3): ");
                    UpgradePointsManager.redeemUpgrade(Integer.parseInt(sc.nextLine()));
                }),
                new Feature("📈 Goal Progress", GoalProgressTracker::showProgress),
                new Feature("🔁 Evaluate Streak", StreakSystem::evaluateStreak),
                new Feature("🎯 View Streak", StreakSystem::showStreak),
                new Feature("🍲 Suggest Meal Plan", MealSuggestionEngine::suggestMealPlan),
                new Feature("🏋️ Suggest Workout", WorkoutSuggestionEngine::suggestWorkout),
                new Feature("🔍 Search Meal", MealSearchEngine::searchMeal),
                new Feature("🧬 Add Nutrition Info", NutritionInfoManager::addNutritionInfo),
                new Feature("📊 View Nutrition Info", NutritionInfoManager::viewNutritionInfo),
                new Feature("📆 Set Goals", HealthGoalManager::setGoals),
                new Feature("🎯 Compare with Friends", ComparisonBoard::showComparison)
        );

        final int ITEMS_PER_PAGE = 5;
        Scanner scanner = new Scanner(System.in);
        int currentPage = 0;
        boolean running = true;

        while (running) {
            clearScreen();
            printTitle();

            int start = currentPage * ITEMS_PER_PAGE;
            int end = Math.min(start + ITEMS_PER_PAGE, features.size());

            int padding = (24 - (end - start + 5)) / 2;
            for (int i = 0; i < padding; i++) System.out.println();

            for (int i = start; i < end; i++) {
                System.out.printf("\u001B[36m[%d] %s\u001B[0m\n", i + 1, features.get(i).label);
            }

            if (end < features.size()) System.out.println("[N] 👉 Next Page");
            if (currentPage > 0) System.out.println("[P] 👈 Previous Page");
            System.out.println("[0] ❌ Exit");
            System.out.print("\n👉 Enter your choice: ");
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "n" -> { if (end < features.size()) currentPage++; }
                case "p" -> { if (currentPage > 0) currentPage--; }
                case "0" -> running = false;
                default -> {
                    try {
                        int index = Integer.parseInt(input) - 1;
                        if (index >= 0 && index < features.size()) {
                            clearScreen();
                            System.out.println("\u001B[32m➡️ Running: " + features.get(index).label + "\u001B[0m\n");
                            features.get(index).action.run();
                            System.out.println("\n\u001B[35m🔁 Press Enter to return...\u001B[0m");
                            scanner.nextLine();
                        } else {
                            System.out.println("\u001B[31mInvalid option. Try again.\u001B[0m");
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        System.out.println("\u001B[31mInvalid input.\u001B[0m");
                        pause();
                    }
                }
            }
        }
        System.out.println("\u001B[32m👋 Goodbye!\u001B[0m");
    }

    private void printTitle() {
        String title = "💚 SAVOUR THE FLAVOURS OF HEALTH 💚";
        System.out.print("\u001B[1;95m");
        for (char ch : title.toCharArray()) {
            System.out.print(ch);
            try { Thread.sleep(20); } catch (Exception ignored) {}
        }
        System.out.println("\u001B[0m\n");
    }

    private static void pause() {
        try { Thread.sleep(1000); } catch (Exception e) { }
    }

    private static void clearScreen() {
        for (int i = 0; i < 40; i++) System.out.println();
    }
}
