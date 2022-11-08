package hexlet.code;


import java.util.Scanner;


public class Cli {
    /**
     * welcome.
     */
    private static final String WELCOME = "Welcome to the Brain Games!"
            + "\nMay I have your name? ";
    /**
     * ask username.
     */
    public static void haveName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(WELCOME);
        if (scanner.hasNext()) {
            System.out.println("Hello, " + scanner.next() + "!");
        }
    }
}
