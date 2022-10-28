package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;
import java.util.Arrays;

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
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionList[i] = makeExpression();
            answerList[i] = makeSolution();
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }
    /**
     * find gcd question params.
     * @return params string.
     */
    private static String makeExpression() {
        var sb = new StringBuilder();
        firstNum = RandomUtils.makeRandom(MAXRND);
        sb.append(firstNum);
        sb.append(" ");
        secondNum = RandomUtils.makeRandom(MAXRND);
        sb.append(secondNum);
        return sb.toString();
    }
    /**
     * make correct answer.
     * @return solution string.
     */
    public static String makeSolution() {
        int[] arr = {firstNum, secondNum};
        Arrays.sort(arr);
        var remainder = arr[0];
        do {
            if (remainder == 0) {
                break;
            }
            remainder = arr[1] % arr[0];
            arr[1] = arr[0];
            arr[0] = remainder;
        } while (remainder != 0);
        return String.valueOf(arr[1]);
    }

}