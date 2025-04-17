package features;

import utils.ConsoleColors;

public class DataResetter {

    public static void resetAllData() {
        MealManager.clearMeals();
        ExerciseManager.clearExercises();
        SleepTracker.clearSleepData();
        WaterTracker.clearWaterData();

        System.out.println(ConsoleColors.RED + "⚠️ All data has been reset successfully." + ConsoleColors.RESET);
    }
}
