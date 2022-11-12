package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.HashMap;

public class CalculatingGame {
    /**
     * result of expression.
     */
    private static int result; //так, зачем глобальную переменную - то? делаешь локальную, и геттеры с сеттерами))
    /**
     * max random number.
     */
    public static final int MAXRND = 100;
    /**
     * max games quantity.
     */
    public static final int MAXMATHOPERATIONS = 3;
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * game condition question.
     */
    private static final String GAMECONDITION =
            "What is the result of the expression?";
    /**
     * start Calc game logic.
     */
    public static void play() {
        HashMap<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < GAMES; i++) {
            int firstNumber = RandomUtils.makeRandom(0, MAXRND);
            int secondNumber = RandomUtils.makeRandom(0, MAXRND);
            int mathOperation = RandomUtils.makeRandom(0, MAXMATHOPERATIONS);
            questionsAndAnswers.put(makeMathExpression(
                    firstNumber,
                    mathOperation,
                    secondNumber),
                    String.valueOf(result));
        }
        GameEngine.run(GAMECONDITION, questionsAndAnswers);
    }
    /**
     * Calc game make expression logic.
     * @param firstNumber first number of the expression.
     * @param mathOperation expression math operator id.
     * @param secondNumber second number of the expression.
     * @return question string.
     */
    public static String makeMathExpression(
            final int firstNumber,
            final int mathOperation,
            final int secondNumber
    ) {
        var sb = new StringBuilder();
        sb.append(firstNumber).append(" ");
        char mathOperator;
        switch (mathOperation) {
            case 0 -> {
                mathOperator = '+';
                result = firstNumber + secondNumber;
            }
            case 1 -> {
                mathOperator = '-';
                result = firstNumber - secondNumber;
            }
            case 2 -> {
                mathOperator = '*';
                result = firstNumber * secondNumber;
            }
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        }
        sb.append(mathOperator).append(" ");
        sb.append(secondNumber);
        return sb.toString();
    }
}
