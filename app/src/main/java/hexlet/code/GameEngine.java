package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {
    /**
     * quest wins count.
     */
    private static int count = 0;
    /**
     * user input answer.
     */
    private static String input = null;
    /**
     * scanner class instance.
     */
    private static final Scanner SCANNER = new Scanner(System.in);
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
        String name = null;
        System.out.print(WELCOME);
        if (SCANNER.hasNext()) {
            name = SCANNER.next();
            System.out.println("Hello, " + name + "!");
        }
        System.out.println(gameQuest);
        for (Map.Entry<String, String> entry: questionsAndAnswers.entrySet()) {
            System.out.print("Question: " + entry.getKey() + "\nYour answer: ");
            if (SCANNER.hasNext()) {
                input = SCANNER.next();
            }
            if (input.equals(entry.getValue())) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.print("'" + input + NOPE + entry.getValue()
                        + AGAIN + name + "!");
                break;
            }
        }
        if (count == questionsAndAnswers.size()) {
            System.out.println("Congratulations, " + name + "!");
        }
        SCANNER.close();
    }
}
