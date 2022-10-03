package hexlet.code;

import java.util.Scanner;


public class Cli {
    /**
     * ask username.
     */
    public static void haveName() {
        String welcome = welcome();
        System.out.print(welcome);
        Scanner sc = new Scanner(System.in);
        String scName = sc.next();
        System.out.println("Hello, " + scName + "!");
    }
    /**
     * System.in scanner per user dialog game.
     * @return welcom string.
     */
    public static String welcome() {
        return "Welcome to the Brain Games!"
                + "\nMay I have your name? ";
    }
}