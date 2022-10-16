package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Calc {
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
        String userName = HelloUtils.hello();
        List<List<Object>> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            questionList.add(makeExpression());
            answerList.add(makeSolution(questionList.get(i)));
        }
        String gameQuest = "What is the result of the expression?";
        var engine = new GameEngine(
                userName,
                gameQuest,
                questionList,
                answerList);
        GameEngine.run(engine);
    }
    /**
     * Calc game random logic.
     *
     * @return question string.
     */
    public static List<Object> makeExpression() {
        var list = new ArrayList<>();
        int firstRND = RandomUtils.makeRandom(MAXRND);
        list.add(firstRND);
        int mathOperation = RandomUtils.makeRandom(MAXMATHOPERATIONS);
        var mathOperator = switch (mathOperation) {
            case 0 -> " + ";
            case 1 -> " - ";
            case 2 -> " * ";
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        };
        list.add(mathOperator);
        int secondRND = RandomUtils.makeRandom(MAXRND);
        list.add(secondRND);
        return list;
    }

    /**
     * correct answer.
     * @param quest game quest params.
     * @return answer int.
     */
    public static String makeSolution(final List<Object> quest) {
        var firstInt = Integer.parseInt(quest.get(0).toString());
        var secondInt = Integer.parseInt(quest.get(2).toString());
        var result = switch (quest.get(1).toString()) {
            case  " + " -> firstInt + secondInt;
            case  " - " -> firstInt - secondInt;
            case  " * " -> firstInt * secondInt;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + quest.get(1).toString());
        };
        return String.valueOf(result);
    }

}
