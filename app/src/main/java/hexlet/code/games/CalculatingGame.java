package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.HashMap;

public class CalculatingGame {
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
            String question = makeMathExpression(firstNumber,
                    mathOperation,
                    secondNumber)[0];
            String answer = makeMathExpression(firstNumber,
                    mathOperation,
                    secondNumber)[1];
            questionsAndAnswers.put(question, answer);
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
    public static String[] makeMathExpression(
            final int firstNumber,
            final int mathOperation,
            final int secondNumber
    ) {
        String[] expression = new String[2];
        int result;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstNumber).append(" ");
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
        stringBuilder.append(mathOperator).append(" ");
        expression[0] = stringBuilder.append(secondNumber).toString();
        expression[1] = String.valueOf(result);
        return expression;
    }
}
