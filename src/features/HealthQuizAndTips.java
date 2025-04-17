package features;

import utils.ConsoleColors;
import java.util.Random;
import java.util.Scanner;

public class HealthQuizAndTips {

    private static final String[] tips = {
            "Drink water before every meal.",
            "Avoid eating late at night.",
            "Stretch for 5 minutes every morning.",
            "Choose stairs over elevators.",
            "Snack on nuts or fruits instead of chips."
    };

    private static final String[] questions = {
            "How many hours of sleep are recommended for adults?",
            "What is the healthiest drink?",
            "What is a good source of protein?",
            "What helps improve flexibility?",
            "What should you eat more of: fiber or sugar?"
    };

    private static final String[][] options = {
            {"5-6", "7-9", "10-12", "Less than 5"},
            {"Cola", "Milkshake", "Water", "Juice"},
            {"Candy", "Chips", "Chicken", "Cake"},
            {"Running", "Stretching", "Sitting", "Sleeping"},
            {"Sugar", "Salt", "Fiber", "Butter"}
    };

    private static final int[] correctAnswers = {2, 3, 3, 2, 3}; // 1-based

    public static void showRandom() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        if (random.nextBoolean()) {
            int qIndex = random.nextInt(questions.length);
            System.out.println(ConsoleColors.BLUE + "\n🧠 Quiz Time:");
            System.out.println(questions[qIndex]);

            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + ". " + options[qIndex][i]);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = Integer.parseInt(scanner.nextLine());

            if (answer == correctAnswers[qIndex]) {
                System.out.println(ConsoleColors.GREEN + "✅ Correct!" + ConsoleColors.RESET);
            } else {
                System.out.println(ConsoleColors.RED + "❌ Wrong. The correct answer was: " +
                        options[qIndex][correctAnswers[qIndex] - 1] + ConsoleColors.RESET);
            }

        } else {
            int tipIndex = random.nextInt(tips.length);
            System.out.println(ConsoleColors.CYAN + "\n🌟 Tip of the Day: " + tips[tipIndex] + ConsoleColors.RESET);
        }
    }
}
