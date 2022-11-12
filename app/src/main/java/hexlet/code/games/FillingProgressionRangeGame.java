package hexlet.code.games;

import hexlet.code.GameEngine;
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
        String[] questionArray = new String[GAMES];
        String[] answerArray = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            int firstRangeNum = RandomUtils.makeRandom(0, MAXRND);
            int stepRange = RandomUtils.makeRandom(0, MAXSTEP) + 1;
            int rangeSize = RandomUtils.makeRandom(MIN_LENGTH, MAX_LENGTH);
            int missedNumIndex = RandomUtils.makeRandom(0, rangeSize - 1);
            int[] questArr = makeProgression(
                    firstRangeNum,
                    stepRange,
                    rangeSize);
            questionArray[i] = makeQuestion(questArr, missedNumIndex);
            int result = questArr[missedNumIndex];
            answerArray[i] = String.valueOf(result);
        }
        GameEngine.run(GAMECONDITION, questionArray, answerArray);
    }

    /**
     * rebuild progression array with missed number.
     * @param questionArray progression array.
     * @param missedNumberIndex number to find index.
     * @return incomplete progression.
     */
    private static String makeQuestion(
            final int[] questionArray,
            final int missedNumberIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < questionArray.length; i++) {
            String num = i == missedNumberIndex
                    ? ".."
                    : String.valueOf(questionArray[i]);
            String separator = i != questionArray.length - 1 ? " " : "";
            stringBuilder.append(num).append(separator);
        }
        return stringBuilder.toString();
    }

    /**
     * make progression range of numbers.
     * @param firstRangeNum number wich starts progression.
     * @param stepRange difference between two closest numbers in range.
     * @param rangeSize progression range size.
     * @return progression array.
     */
    public static int[] makeProgression(
            final int firstRangeNum,
            final int stepRange,
            final int rangeSize) {
        int[] progressionArr;
        progressionArr = new int[rangeSize];
        for (int i = 0; i < rangeSize; i++) {
            progressionArr[i] = firstRangeNum + stepRange * i;
        }
        return progressionArr;
    }
}

