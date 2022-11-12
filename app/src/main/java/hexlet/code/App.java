package hexlet.code;

import hexlet.code.games.CalculatingGame;
import hexlet.code.games.FillingProgressionRangeGame;
import hexlet.code.games.FindingGCDGame;
import hexlet.code.games.EvenOddGame;
import hexlet.code.games.ChoosingIfPrimeGame;
import java.util.Scanner;

public class App {
     /**
     * main method to run.
     * @param args args array.
     */
    public static void main(final String[] args) {
        makeUserDialog();
    }
    /**
     * user dialog init.
     */
    public static void makeUserDialog() {
        final int welcomeId = 1;
        final int evenId = 2;
        final int calcID = 3;
        final int gcdId = 4;
        final int progressionId = 5;
        final int primeId = 6;
        int intScan;
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        intScan = sc.nextInt();
        System.out.println("Your choice: " + intScan);
        switch (intScan) {
            case welcomeId -> Cli.haveName();
            case evenId -> EvenOddGame.play();
            case calcID -> CalculatingGame.play();
            case gcdId -> FindingGCDGame.play();
            case progressionId -> FillingProgressionRangeGame.play();
            case primeId -> ChoosingIfPrimeGame.play();
            default -> System.out.print("Exit.");
        }
        sc.close();
    }
}
