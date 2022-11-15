package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.HashMap;

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
        HashMap<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < GAMES; i++) {
            int firstRangeNumber = RandomUtils.makeRandom(0, MAXRND);
            int stepRange = RandomUtils.makeRandom(0, MAXSTEP) + 1;
            int rangeSize = RandomUtils.makeRandom(MIN_LENGTH, MAX_LENGTH);
            int missedNumberIndex = RandomUtils.makeRandom(0, rangeSize - 1);
            int[] progression = makeProgression(
                    firstRangeNumber,
                    stepRange,
                    rangeSize);
            int result = progression[missedNumberIndex];
            questionsAndAnswers.put(
                    makeQuestion(progression, missedNumberIndex),
                    String.valueOf(result));
        }
        GameEngine.run(GAMECONDITION, questionsAndAnswers);
    }
    /**
     * rebuild progression array with missed number.
     * @param progression progression array.
     * @param missedNumberIndex number to find index.
     * @return incomplete progression.
     */
    private static String makeQuestion(
            final int[] progression,
            final int missedNumberIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            String num = i == missedNumberIndex
                    ? ".."
                    : String.valueOf(progression[i]);
            String separator = i != progression.length - 1 ? " " : "";
            stringBuilder.append(num).append(separator);
        }
        return stringBuilder.toString();
    }

    /**
     * make progression range of numbers.
     * @param firstRangeNumber number wich starts progression.
     * @param stepRange difference between two closest numbers in range.
     * @param rangeSize progression range size.
     * @return progression array.
     */
    public static int[] makeProgression(
            final int firstRangeNumber,
            final int stepRange,
            final int rangeSize) {
        int[] progression;
        progression = new int[rangeSize];
        for (int i = 0; i < rangeSize; i++) {
            progression[i] = firstRangeNumber + stepRange * i;
        }
        return progression;
    }
}

