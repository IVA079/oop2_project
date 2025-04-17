import features.Dashboard;
import utils.LightningBar;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LightningBar.showLoading("🔋 Booting Your Health Engine");

        // Sample values — will be real later
        int meals = 3;
        int calories = 1400;
        int workouts = 2;
        double sleep = 7.5;
        int water = 6;
        String mood = "😊 Happy";
        int streak = 5;

        Dashboard.showDashboard(meals, calories, workouts, sleep, water, mood, streak);
    }
}
