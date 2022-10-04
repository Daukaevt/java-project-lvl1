package hexlet.code;

//
//import hexlet.gradle.project.games.Calc;
//import hexlet.gradle.project.games.GCD;
//import hexlet.gradle.project.games.Progression;
//import hexlet.gradle.project.games.Prime;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

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
                case EVEN -> Even.play();
                case CALC -> Calc.play();
               // case GCD -> hexlet.gradle.project.games.GCD.play();
               // case PROGRESSION -> Progression.play();
              //  case PRIME -> Prime.play();
                default -> {
                }
            }
        }
        sc.close();
    }
}
