package hexlet.code.games;



import hexlet.code.EngineData;
import hexlet.code.GameEngine;
import org.mariuszgromada.math.mxparser.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calc {
    /**
     * Welcome string.
     */
    public static final String welcome = "Welcome to the Brain Games!"
            + "\nMay I have your name? ";
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
     * start Calc game logic.
     */
    public static void play() {
        System.out.print(welcome);
        List<Object> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            questionList.add(makeExpression());
            answerList.add(makeSolution(String.valueOf(questionList.get(i))));
        }
        String gameQuest = "What is the result of the expression?";
        var engine = new EngineData(
                gameQuest,
                questionList,
                answerList);
        GameEngine.getFullString(engine);
    }
    /**
     * Calc game random logic.
     *
     * @return question string.
     */
    public static Object makeExpression() {
        int firstRND = random(MAXRND);
        int secondRND = random(MAXRND);
        int mathOperation = random(MAXMATHOPERATIONS);
        var mathOperator = switch (mathOperation) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        };
        return firstRND + mathOperator + secondRND;
    }
    public static String makeSolution(final String quest) {
        Expression expr = new Expression(quest);
        double d = expr.calculate();
        int solution = (int) d;
        return Integer.toString(solution);
    }
    public static int random(final int max) {
        Random rnd = new Random(); //instance of random class
        return rnd.nextInt(0, max);
    }

}
