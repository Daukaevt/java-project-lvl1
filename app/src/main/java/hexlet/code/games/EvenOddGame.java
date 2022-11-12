package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.HashMap;

public class EvenOddGame {
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;

    /**
     * game condition question.
     */
    private static final String GAMECONDITION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";
    /**
     * check if given nuber is even.
     * @param num given number.
     * @return 'yes' or 'no' answer.
     */
    public static boolean isEven(final int num) {
        return num % 2 == 0;
    }
    /**
     * start Even game logic.
     */
    public static void play() {
        int i = 0;
        HashMap<String, String> questionsAndAnswers = new HashMap<>();
        while (i < GAMES) {
            var randomNumber = RandomUtils.makeRandom(0, MAXRND);
            questionsAndAnswers.put(
                    String.valueOf(randomNumber),
                    isEven(randomNumber) ? "yes" : "no");
            i++;
        }
        GameEngine.run(GAMECONDITION, questionsAndAnswers);
    }
}
