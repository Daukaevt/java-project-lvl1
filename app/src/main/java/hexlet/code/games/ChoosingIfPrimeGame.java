package hexlet.code.games;

import hexlet.code.utils.RandomUtils;
import hexlet.code.GameEngine;

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
        String[] questionArray = new String[GAMES];
        String[] answerArray = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionArray[i] = String
                    .valueOf(RandomUtils.makeRandom(0, MAXRND));
            answerArray[i] = isPrime(Integer.parseInt(questionArray[i])) ? "yes" : "no";
        }
        GameEngine.run(GAMECONDITION, questionArray, answerArray);
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

