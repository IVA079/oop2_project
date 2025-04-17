package features;

import utils.ConsoleColors;
import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ConsoleColors.YELLOW + "Enter your weight (in kg): " + ConsoleColors.RESET);
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print(ConsoleColors.YELLOW + "Enter your height (in meters): " + ConsoleColors.RESET);
        double height = Double.parseDouble(scanner.nextLine());

        if (height <= 0) {
            System.out.println(ConsoleColors.RED + "❌ Invalid height." + ConsoleColors.RESET);
            return;
        }

        double bmi = weight / (height * height);
        System.out.println(ConsoleColors.CYAN + "\n⚖️ Your BMI is: " + String.format("%.2f", bmi));

        if (bmi < 18.5) {
            System.out.println("🔎 Category: Underweight");
        } else if (bmi < 24.9) {
            System.out.println("✅ Category: Normal weight");
        } else if (bmi < 29.9) {
            System.out.println("⚠️ Category: Overweight");
        } else {
            System.out.println("❌ Category: Obese");
        }

        System.out.println(ConsoleColors.RESET);
    }
}
