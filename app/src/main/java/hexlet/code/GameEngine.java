package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {
    /**
     * username.
     */
    private static String name = null;
    /**
     * user input.
     */
    private static String input = "";
    /**
     * wrong answer remark.
     */
    private static final String NOPE =
            "' is wrong answer ;(. Correct answer was '";
    /**
     * try again remark.
     */
    private static final String AGAIN = "'\nLet's try again, ";
    /**
     * welcome.
     */
    private static final String WELCOME = "Welcome to the Brain Games!"
            + "\nMay I have your name? ";
    /**
     * engine quest building method.
     * @param gameQuest game conditions.
     * @param questionsAndAnswers map of game questions & answers.
     */
    public static void run(
            final String gameQuest,
            final HashMap<String, String> questionsAndAnswers) {
        int count = 0;
        final Scanner scanner = new Scanner(System.in);
        System.out.print(WELCOME);
        if (scanner.hasNext()) {
            name = scanner.next();
            System.out.println("Hello, " + name + "!\n" + gameQuest);
        }
        for (Map.Entry<String, String> entry: questionsAndAnswers.entrySet()) {
            System.out.print("Question: " + entry.getKey() + "\nYour answer: ");
            if (scanner.hasNext()) {
                input = scanner.next();
            }
            if (input.equals(entry.getValue())) {
                System.out.print("Correct!");
                count++;
            } else {
                System.out.println("'" + input + NOPE
                        + entry.getValue() + AGAIN + name + "!");
                break;
            }
            System.out.println(count == questionsAndAnswers.size()
                    ? "\nCongratulations, " + name + "!" : "");
        }
        scanner.close();
    }
}
