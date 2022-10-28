package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.CalcUtils;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;

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
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            int firstNum = RandomUtils.makeRandom(MAXRND);
            int secondNum = RandomUtils.makeRandom(MAXRND);
            int mathOperation = RandomUtils.makeRandom(MAXMATHOPERATIONS);
            questionList[i] = CalcUtils.makeExpression(
                    firstNum,
                    mathOperation,
                    secondNum);
            answerList[i] = String.valueOf(CalcUtils.makeSolution());
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }

}
