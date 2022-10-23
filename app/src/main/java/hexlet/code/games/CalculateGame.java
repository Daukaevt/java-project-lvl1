package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;

public class CalculateGame {
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
     * start Calc game logic.
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
     * Calc game random logic.
     *
     * @return question string.
     */
    public static String makeExpression() {
        var sb = new StringBuilder();
        int firstRND = RandomUtils.makeRandom(MAXRND);
        sb.append(firstRND);
        int mathOperation = RandomUtils.makeRandom(MAXMATHOPERATIONS);
        var mathOperator = switch (mathOperation) {
            case 0 -> " + ";
            case 1 -> " - ";
            case 2 -> " * ";
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        };
        sb.append(mathOperator);
        int secondRND = RandomUtils.makeRandom(MAXRND);
        sb.append(secondRND);
        return sb.toString();
    }

    /**
     * correct answer.
     * @param quest game quest params.
     * @return answer int.
     */
    public static String makeSolution(final String quest) {
        var strArr = quest.split(" ");
        var firstInt = Integer.parseInt(strArr[0]);
        var secondInt = Integer.parseInt(strArr[2]);
        var result = switch (strArr[1]) {
            case  "+" -> firstInt + secondInt;
            case  "-" -> firstInt - secondInt;
            case  "*" -> firstInt * secondInt;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + quest);
        };
        return String.valueOf(result);
    }

}
