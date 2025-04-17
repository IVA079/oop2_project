package utils;

public class LightningBar {
    public static void showLoading(String taskName) throws InterruptedException {
        System.out.print(ConsoleColors.PURPLE + taskName + ": [" + ConsoleColors.RESET);

        for (int i = 0; i < 30; i++) {
            System.out.print(ConsoleColors.CYAN + "⚡" + ConsoleColors.RESET);
            Thread.sleep(25);
        }

        System.out.println(ConsoleColors.PURPLE + "] Done!" + ConsoleColors.RESET);
    }
}
