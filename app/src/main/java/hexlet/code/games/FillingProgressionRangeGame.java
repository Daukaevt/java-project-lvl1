package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.ProgressionUtils;
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
            int firstRangeNum = RandomUtils.makeRandom(MAXRND);
            int stepRange = RandomUtils.makeRandom(MAXSTEP) + 1;
            int indexedRange = RandomUtils.makeRandom(PR_LENGTH);
            questionList[i] = ProgressionUtils.makeExpression(firstRangeNum, stepRange, indexedRange);
            answerList[i] = String.valueOf(getResult(firstRangeNum, stepRange, indexedRange));
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }

    private static int getResult(int firstRangeNum, int stepRange, int indexedRange) {
        return firstRangeNum + stepRange*indexedRange;
    }
}

