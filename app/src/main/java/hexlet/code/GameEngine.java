package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {
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
        String name = null;
        String input = "";
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
                System.out.println("Correct!");
                count++;
            } else {
                System.out.print("'" + input + NOPE + entry.getValue()
                        + AGAIN + name + "!");
                break;
            }
        }
        System.out.println(count == questionsAndAnswers.size()
                ? "Congratulations, " + name + "!" : "");
        scanner.close();
    }
}
