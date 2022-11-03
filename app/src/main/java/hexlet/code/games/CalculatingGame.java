package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;

public class CalculatingGame {
    /**
     * result of expression.
     */
    private static int result;
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
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            int firstNum = RandomUtils.makeRandom(0, MAXRND);
            int secondNum = RandomUtils.makeRandom(0, MAXRND);
            int mathOperation = RandomUtils.makeRandom(0, MAXMATHOPERATIONS);
            questionList[i] = makeMathExpression(
                    firstNum,
                    mathOperation,
                    secondNum);
            answerList[i] = String.valueOf(result);
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }


    /**
     * Calc game make expression logic.
     * @param firstNum first number of the expression.
     * @param mathOperation expression math operator id.
     * @param secondNum second number of the expression.
     * @return question string.
     */
    public static String makeMathExpression(
            final int firstNum,
            final int mathOperation,
            final int secondNum) {
        var sb = new StringBuilder();
        sb.append(firstNum).append(" ");
        char mathOperator;
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
