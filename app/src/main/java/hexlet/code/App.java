package hexlet.code;



import hexlet.code.games.CalculatingGame;
import hexlet.code.games.FillingProgressionRangeGame;
import hexlet.code.games.FindingGCDGame;
import hexlet.code.games.EvenOddGame;
import hexlet.code.games.ChoosingIfPrimeGame;

import java.util.Scanner;

public class App {
    /**
     * Even game id.
     */
    private static final int WELCOME = 1;
    /**
     * Even game id.
     */
    private static final int EVEN = 2;
    /**
     * Calc game id.
     */
    public static final int CALC = 3;
    /**
     * GCD game id.
     */
    public static final int GCD = 4;
    /**
     * Progression game id.
     */
    public static final int PROGRESSION = 5;
    /**
     * Progression game id.
     */
    public static final int PRIME = 6;

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
            case WELCOME -> Cli.haveName();
            case EVEN -> EvenOddGame.play();
            case CALC -> CalculatingGame.play();
            case GCD -> FindingGCDGame.play();
            case PROGRESSION -> FillingProgressionRangeGame.play();
            case PRIME -> ChoosingIfPrimeGame.play();
            default -> {
                System.out.print("Exit.");
            }
        }
        sc.close();
    }
}
