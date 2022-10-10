package hexlet.code;


import java.util.List;
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
     * game quest data.
     */
    private final String gameQuest;
    /**
     *  list of 3 quests.
     */
    private final List<String> questList;
    /**
     * list of 3 answers.
     */
    private final List<String> answerList;

    /**
     * data class.
     * @param quest game question.
     * @param listQuest list of game question params.
     * @param listAnswer list of game answers.
     */
    public GameEngine(
            final String quest,
            final List<String> listQuest,
            final List<String> listAnswer
    ) {
        this.gameQuest = quest;
        this.questList = listQuest;
        this.answerList = listAnswer;
    }

    /**
     * game question.
     * @return game question string.
     */
    public String getGameQuest() {
        return this.gameQuest;
    }

    /**
     * list of game question params.
     * @return quest list.
     */
    public List<String> getQuestList() {
        return this.questList;
    }

    /**
     * list of game answers.
     * @return answers list.
     */
    public List<String> getAnswerList() {
        return this.answerList;
    }

    /**
     * engine quest building method.
     * @param gameEngine datas.
     */
    public static void getFullString(final GameEngine gameEngine) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            name = scanner.next();
            System.out.println("Hello, " + name + "!");
        }
        System.out.println(gameEngine.getGameQuest());
        for (int i = 0; i < GAMES; i++) {
            var quest = gameEngine.getQuestList().get(i);
            System.out.print("Question: " + quest + "\nYour answer: ");
            if (scanner.hasNext()) {
                userAnswer = scanner.next();
            }
            assert userAnswer != null;
            var correctAnswer = gameEngine.getAnswerList().get(i);
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
        if (count == GAMES) {
            System.out.println("Congratulations, " + name + "!");
        }
        scanner.close();
    }
}
