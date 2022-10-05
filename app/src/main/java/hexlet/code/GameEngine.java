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
    private static String userAnswer = null;
    /**
     * username.
     */
    private static String name = "";
    /**
     * engine quest building method.
     * @param engineData game data.
     */
    public static void getFullString(final EngineData engineData) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            System.out.print("Hello, ");
            name = scanner.next();
            System.out.println(name + "!");
        }
        System.out.println(engineData.getGameQuest());
        for (int i = 0; i < GAMES; i++) {
            System.out.println("Question: " + engineData.getQuestList().get(i));
            System.out.print("Your answer: ");
            if (scanner.hasNext()) {
                userAnswer = scanner.next();
            }
            assert userAnswer != null;
            var correctAnswer = engineData.getAnswerList().get(i);
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'\nLet's try again, " + name + "!");
                break;
            }
        }
        while (count == GAMES) {
            System.out.println("Congratulations, " + name + "!");
            break;
        }
        scanner.close();
    }
}
