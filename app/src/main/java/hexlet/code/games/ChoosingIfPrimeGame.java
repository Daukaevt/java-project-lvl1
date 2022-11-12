package hexlet.code.games;

import hexlet.code.utils.RandomUtils;
import hexlet.code.GameEngine;
import java.util.HashMap;

public class ChoosingIfPrimeGame {
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
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    /**
     * start Prime game logic.
     */
    public static void play() {
        HashMap<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < GAMES; i++) {
            var randomNumber = RandomUtils.makeRandom(0, MAXRND);
            questionsAndAnswers.put(
                    String.valueOf(randomNumber),
                    isPrime(randomNumber) ? "yes" : "no");
        }
        GameEngine.run(GAMECONDITION, questionsAndAnswers);
    }
    /**
     * it gives correct answer if given number prime or not.
     * @param quest given number.
     * @return "yes" or "no".
     */
    public static boolean isPrime(
            final int quest) {
        if (quest < 2) {
            return false;
        }
        for (int i = 2; i < quest; i++) {
            if (quest % i == 0) {
                return false;
            }
        }
        return true;
    }
}

