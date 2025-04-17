package features;

import utils.ConsoleColors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseManager {

    public static class Exercise {
        String name;
        int duration; // in minutes
        int caloriesBurned;

        public Exercise(String name, int duration, int caloriesBurned) {
            this.name = name;
            this.duration = duration;
            this.caloriesBurned = caloriesBurned;
        }
    }

    private static final List<Exercise> exercises = new ArrayList<>();

    public static void addExercise() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Enter exercise name: " + ConsoleColors.RESET);
        String name = scanner.nextLine();

        System.out.print(ConsoleColors.YELLOW + "Enter duration (in minutes): " + ConsoleColors.RESET);
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.print(ConsoleColors.YELLOW + "Enter calories burned: " + ConsoleColors.RESET);
        int caloriesBurned = Integer.parseInt(scanner.nextLine());

        exercises.add(new Exercise(name, duration, caloriesBurned));
        System.out.println(ConsoleColors.GREEN + "✅ Exercise logged successfully!" + ConsoleColors.RESET);
    }

    public static void viewExercises() {
        if (exercises.isEmpty()) {
            System.out.println(ConsoleColors.RED + "🚫 No exercises logged yet." + ConsoleColors.RESET);
            return;
        }

        System.out.println(ConsoleColors.PURPLE + "\n🏋️ Workout History:\n");

        String format = "| %-20s | %-10s | %-15s |\n";

        System.out.println("+----------------------+------------+-----------------+");
        System.out.printf(format, "Exercise", "Duration", "Calories Burned");
        System.out.println("+----------------------+------------+-----------------+");

        for (Exercise ex : exercises) {
            System.out.printf(format, ex.name, ex.duration + " min", ex.caloriesBurned + " kcal");
        }

        System.out.println("+----------------------+------------+-----------------+" + ConsoleColors.RESET);
    }

    public static int getWorkoutCount() {
        return exercises.size();
    }

    public static int getTotalBurnedCalories() {
        int total = 0;
        for (Exercise e : exercises) {
            total += e.caloriesBurned;
        }
        return total;
    }

    public static void clearExercises() {
        exercises.clear();
    }
}
