package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;

public class CalculatingGame {
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;
    /**
     * max games quantity.
     */
    public static final int MAXMATHOPERATIONS = 3;
    /**
     * game condition question.
     */
    private static final String GAMECONDITION =
            "What is the result of the expression?";
    /**
     * first expression number.
     */
    private static int firstNum;
    /**
     * expression math operator.
     */
    private static char mathOperator;
    /**
     * second expression number.
     */
    private static int secondNum;

    /**
     * result of expression.
     */
    private static int result;

    /**
     * start Calc game logic.
     */
    public static void play() {
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionList[i] = makeExpression();
            answerList[i] = String.valueOf(result);
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }
    /**
     * Calc game random logic.
     *
     * @return question string.
     */
    public static String makeExpression() {
        var sb = new StringBuilder();
        firstNum = RandomUtils.makeRandom(MAXRND);
        secondNum = RandomUtils.makeRandom(MAXRND);
        sb.append(firstNum).append(" ");
        int mathOperation = RandomUtils.makeRandom(MAXMATHOPERATIONS);
        switch (mathOperation) {
            case 0 -> {
                mathOperator = '+';
                result = firstNum + secondNum;
            }
            case 1 -> {
                mathOperator = '-';
                result = firstNum - secondNum;
            }
            case 2 -> {
                mathOperator = '*';
                result = firstNum * secondNum;
            }
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        }
        sb.append(mathOperator).append(" ");
        sb.append(secondNum);
        return sb.toString();
    }
}
