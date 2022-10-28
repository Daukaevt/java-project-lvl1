package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;

public class FillingProgressionRangeGame {
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;
    /**
     * max random progression step.
     */
    public static final int MAXSTEP = 9;
    /**
     * max progression line length.
     */
    public static final int PR_LENGTH = 9;
    /**
     * progression missing number.
     */
    private static int result;
    /**
     * game condition question.
     */
    private static final String GAMECONDITION =
            "What number is missing in the progression?";
    /**
     * start Progression game logic.
     */
    public static void play() {
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionList[i] = makeExpression();
            answerList[i] = String.valueOf(result);
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }
    /**
     * missing number question params.
     * @return missing number question params string.
     */
    public static String makeExpression() {
        StringBuilder sb = new StringBuilder();
        int firstRangeNum = RandomUtils.makeRandom(MAXRND);
        result = firstRangeNum;
        int stepRange = RandomUtils.makeRandom(MAXSTEP) + 1;
        int indexedRange = RandomUtils.makeRandom(PR_LENGTH);
        for (int i = 0; i <= PR_LENGTH; i++) {
            if (i == indexedRange) {
                sb.append(".. ");
                result += indexedRange * stepRange;
            } else {
                sb.append(firstRangeNum);
                sb.append(" ");
            }
            firstRangeNum += stepRange;
        }
        return sb.toString();
    }
}

