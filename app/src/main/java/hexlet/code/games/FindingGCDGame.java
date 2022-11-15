package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.Arrays;
import java.util.HashMap;

public class FindingGCDGame {
    /**
     * first expression number.
     */
    private static int firstNumber;
    /**
     * second expression number.
     */
    private static int secondNumber;
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
        HashMap<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < GAMES; i++) {
            questionsAndAnswers.put(
                    makeGCDExpression(),
                    String.valueOf(findGCD(firstNumber, secondNumber)));
        }
        GameEngine.run(GAMECONDITION, questionsAndAnswers);
    }
    /**
     * find gcd question params.
     * @return params string.
     */
    private static String makeGCDExpression() {
        var stringBuilder = new StringBuilder();
        firstNumber = RandomUtils.makeRandom(0, MAXRND);
        stringBuilder.append(firstNumber);
        stringBuilder.append(" ");
        secondNumber = RandomUtils.makeRandom(0, MAXRND);
        stringBuilder.append(secondNumber);
        return stringBuilder.toString();
    }
    /**
     * make correct answer.
     * @param firstNum first number of the expression.
     * @param secondNum second number of the expression.
     * @return solution string.
     */
    public static int findGCD(final int firstNum, final int secondNum) {
        int[] numbers = {firstNum, secondNum};
        Arrays.sort(numbers);
        var remainder = numbers[0];
        do {
            if (remainder == 0) {
                break;
            }
            remainder = numbers[1] % numbers[0];
            numbers[1] = numbers[0];
            numbers[0] = remainder;
        } while (remainder != 0);
        return numbers[1];
    }
}
