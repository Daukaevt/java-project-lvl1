package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.NumberUtils;
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
     * min progression line length.
     */
    public static final int MIN_LENGTH = 5;
    /**
     * max progression line length.
     */
    public static final int MAX_LENGTH = 20;
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
            int firstRangeNum = RandomUtils.makeRandom(0, MAXRND);
            int stepRange = RandomUtils.makeRandom(0, MAXSTEP) + 1;
            int rangeSize = RandomUtils.makeRandom(MIN_LENGTH, MAX_LENGTH);
            int missedNumIndex = RandomUtils.makeRandom(0, rangeSize - 1);
            int[] questArr = NumberUtils.makeProgression(
                    firstRangeNum,
                    stepRange,
                    rangeSize);
            questionList[i] = makeQuest(questArr, missedNumIndex);
            int result = questArr[missedNumIndex];
            answerList[i] = String.valueOf(result);
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }

    /**
     * rebuild progression array with missed number.
     * @param questArr progression array.
     * @param missedNumIndex number to find index.
     * @return incomplete progression.
     */
    private static String makeQuest(
            final int[] questArr,
            final int missedNumIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < questArr.length; i++) {
            String num = i == missedNumIndex
                    ? ".."
                    : String.valueOf(questArr[i]);
            String separator = i != questArr.length - 1 ? " " : "";
            stringBuilder.append(num).append(separator);
        }
        return stringBuilder.toString();
    }
}

