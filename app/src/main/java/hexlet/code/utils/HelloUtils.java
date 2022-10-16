package hexlet.code.utils;

import java.util.Scanner;

public class HelloUtils {
    /**
     * welcome.
     */
    private static final String WELCOME = "Welcome to the Brain Games!"
            + "\nMay I have your name? ";

    /**
     * say Hello.
     * @return username.
     */
    public static String hello() {
        String name = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print(WELCOME);
        if (scanner.hasNext()) {
            name = scanner.next();
            System.out.println("Hello, " + name + "!");
        }

        return name;
    }
}
