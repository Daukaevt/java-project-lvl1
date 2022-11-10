package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.NumberUtils;
import hexlet.code.utils.RandomUtils;

public class FindingGCDGame {
    /**
     * first expression number.
     */
    private static int firstNum;
    /**
     * second expression number.
     */
    private static int secondNum;
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;
    /**
     * game condition question.
     */
    private static final String GAMECONDITION =
            "Find the greatest common divisor of given numbers.";
    /**
     * start GCD game logic.
     */
    public static void play() {
        String[] questionArray = new String[GAMES];
        String[] answerArray = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionArray[i] = makeGCDExpression();
            answerArray[i] = String.valueOf(NumberUtils.findGCD(firstNum, secondNum));
        }
        GameEngine.run(GAMECONDITION, questionArray, answerArray);
    }
    /**
     * find gcd question params.
     * @return params string.
     */
    private static String makeGCDExpression() {
        var stringBuilder = new StringBuilder();
        firstNum = RandomUtils.makeRandom(0, MAXRND);
        stringBuilder.append(firstNum);
        stringBuilder.append(" ");
        secondNum = RandomUtils.makeRandom(0, MAXRND);
        stringBuilder.append(secondNum);
        return stringBuilder.toString();
    }
}
