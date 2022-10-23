package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;
import java.util.Arrays;

public class FindGCDGame {
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
            answerList[i] = makeSolution(questionList[i]);
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }
    /**
     * make correct answer.
     * @param quest find gcd question params.
     * @return solution string.
     */
    public static String makeSolution(
            final String quest) {
        var str = quest.split(" ");
        int[] arr = {Integer.parseInt(str[0]), Integer.parseInt(str[1])};
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
    /**
     * find gcd question params.
     * @return params string.
     */
    private static String makeExpression() {
        var sb = new StringBuilder();
        int firstRND = Integer.parseInt(
                String.valueOf(RandomUtils.makeRandom(MAXRND)));
        sb.append(firstRND);
        sb.append(" ");
        int secondRND = Integer.parseInt(
                String.valueOf(RandomUtils.makeRandom(MAXRND)));
        sb.append(secondRND);
        return sb.toString();
    }
}
