package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCD {
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;
    /**
     * start GCD game logic.
     */
    public static void play() {
        String gameQuest =
                "Find the greatest common divisor of given numbers.";
        String userName = HelloUtils.hello();
        List<List<Object>> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            questionList.add(makeExpression());
            answerList.add(makeSolution(questionList.get(i)));
        }
        var engine = new GameEngine(
                userName,
                gameQuest,
                questionList,
                answerList);
        GameEngine.run(engine);
    }
    /**
     * make correct answer.
     * @param quest find gcd question params.
     * @return solution string.
     */
    public static String makeSolution(
            final List<Object> quest) {
        int[] arr = {(int) quest.get(0), (int) quest.get(2)};
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
    private static List<Object> makeExpression() {
        var list = new ArrayList<>();
        int firstRND = Integer.parseInt(
                String.valueOf(RandomUtils.makeRandom(MAXRND)));
        list.add(firstRND);
        list.add(" ");
        int secondRND = Integer.parseInt(
                String.valueOf(RandomUtils.makeRandom(MAXRND)));
        list.add(secondRND);
        return list;
    }
}
