package hexlet.code;



import hexlet.code.games.CalculateGame;
import hexlet.code.games.FillProgressionRangeGame;
import hexlet.code.games.FindGCDGame;
import hexlet.code.games.IfEvenGame;
import hexlet.code.games.IfPrimeGame;

import java.util.Scanner;

public class App {
    /**
     * max game id.
     */
    private static final int MAXID = 6;
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
        if (0 < intScan && intScan <= MAXID) {
            switch (intScan) {
                case WELCOME -> Cli.haveName();
                case EVEN -> IfEvenGame.play();
                case CALC -> CalculateGame.play();
                case GCD -> FindGCDGame.play();
                case PROGRESSION -> FillProgressionRangeGame.play();
                case PRIME -> IfPrimeGame.play();
                default -> {
                }
            }
        }
        sc.close();
    }
}
