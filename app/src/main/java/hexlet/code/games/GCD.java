package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCD {
    /**
     * welcome.
     */
    private static final String WELCOME = "Welcome to the Brain Games!"
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
     * start GCD game logic.
     */
    public static void play() {
        String gameQuest =
                "Find the greatest common divisor of given numbers.";
        System.out.print(WELCOME);
        List<String> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            questionList.add(makeExpression());
            answerList.add(makeSolution(questionList.get(i)));
        }
        var engine = new GameEngine(
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
            final String quest) {
        String[] str = quest.split(" ");
        var firstInt = Integer.parseInt(str[0]);
        var secondInt = Integer.parseInt(str[1]);
        int[] arr = {firstInt, secondInt};
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
    private static String makeExpression() {
        int firstRND = Integer.parseInt(String.valueOf(RandomUtils.makeRandom(MAXRND)));
        int secondRND = Integer.parseInt(String.valueOf(RandomUtils.makeRandom(MAXRND)));
        return firstRND + " " + secondRND;
    }
}
