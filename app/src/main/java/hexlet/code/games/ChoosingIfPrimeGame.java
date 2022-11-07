package hexlet.code.games;

import hexlet.code.utils.NumberUtils;
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
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionList[i] = String.valueOf(RandomUtils.makeRandom(0, MAXRND));
            answerList[i] = NumberUtils
                    .isPrime(Integer.parseInt(questionList[i]));
        }
        GameEngine.run(GAMECONDITION, questionList, answerList);
    }
}

