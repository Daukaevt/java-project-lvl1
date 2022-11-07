package hexlet.code;


import java.util.Scanner;

public class GameEngine {
    /**
     * number of games.
     */
    public static final int GAMES = 3;
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
    static String name = null;
    /**
     * engine quest building method.
     * @param gameQuest game conditions.
     * @param questions array of quests.
     * @param answers array of answers.
     */
    public static void run(final String gameQuest,
            final String[] questions, final String[] answers) {
        System.out.print(WELCOME);
        if (SCANNER.hasNext()) {
            name = SCANNER.next();
            System.out.println("Hello, " + name + "!");
        }
        System.out.println(gameQuest);
        for (int i = 0; i < GAMES; i++) {
            var answer = answers[i];
            System.out.print("Question: " + questions[i] + "\nYour answer: ");
            if (SCANNER.hasNext()) {
                input = SCANNER.next();
            }
            if (input.equals(answer)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.print("'" + input + NOPE + answer
                        + AGAIN + name + "!");
                break;
            }
        }
        if (count == GAMES) {
            System.out.println("Congratulations, " + name + "!");
        }
        SCANNER.close();
    }
}
