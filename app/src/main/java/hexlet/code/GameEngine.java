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
    private static String input = null;
    /**
     * username.
     */
    private static String userNameStr;
    /**
     * game quest data.
     */
    private final String gameQuest;
    /**
     *  list of 3 quests.
     */
    private final List<List<Object>> questList;
    /**
     * list of 3 answers.
     */
    private final List<String> answerList;

    /**
     * data class.
     * @param userName username.
     * @param quest      game question.
     * @param listQuest  list of game question params.
     * @param listAnswer list of game answers.
     */
    public GameEngine(
            final String userName,
            final String quest,
            final List<List<Object>> listQuest,
            final List<String> listAnswer
    ) {
        this.userNameStr = userName;
        this.gameQuest = quest;
        this.questList = listQuest;
        this.answerList = listAnswer;
    }
    /**
     * game question.
     * @return game question string.
     */
    public String getName() {
        return userNameStr;
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
    public List<List<Object>> getQuestList() {
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
     * string builder class instance.
     */
    private static final StringBuilder SB = new StringBuilder();
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
     * @param engine datas.
     */
    public static void run(final GameEngine engine) {
        System.out.println(engine.getGameQuest());
        for (int i = 0; i < GAMES; i++) {
            for (Object o : engine.getQuestList().get(i)) {
                SB.append(o);
            }
            System.out.print("Question: " + SB + "\nYour answer: ");
            SB.setLength(0);
            if (SCANNER.hasNext()) {
                input = SCANNER.next();
            }
            var yep = engine.getAnswerList().get(i);
            if (input.equals(yep)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.print("'" + input + NOPE + yep
                        + AGAIN + engine.getName() + "!");
                break;
            }
        }
        if (count == GAMES) {
            System.out.println("Congratulations, " + engine.getName() + "!");
        }
        SCANNER.close();
    }
}
