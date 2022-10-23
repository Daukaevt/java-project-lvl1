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
     * engine quest building method.
     * @param userNameStr username.
     * @param gameQuest game conditions.
     * @param questions array of quests.
     * @param answers array of answers.
     */
    public static void run(final String userNameStr, final String gameQuest,
            final String[] questions, final String[] answers) {
        System.out.println(gameQuest);
        for (int i = 0; i < GAMES; i++) {
            System.out.print("Question: " + questions[i] + "\nYour answer: ");
            if (SCANNER.hasNext()) {
                input = SCANNER.next();
            }
            if (input.equals(answers[i])) {
                System.out.println("Correct!");
                do {
                    count++;
                } while (count < GAMES);
            } else {
                System.out.print("'" + input + NOPE + answers[i]
                        + AGAIN + userNameStr + "!");
                break;
            }
        }
        System.out.println("Congratulations, " + userNameStr + "!");
        SCANNER.close();
    }
}
