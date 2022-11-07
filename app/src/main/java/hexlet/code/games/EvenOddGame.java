package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.NumberUtils;
import hexlet.code.utils.RandomUtils;

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
     * array of questions.
     */
    private static final String[] QUESTIONARR = new String[GAMES];
    /**
     * array of answers.
     */
    private static final String[] ANSWERARR = new String[GAMES];
    /**
     * start Even game logic.
     */
    public static void play() {
        for (int i = 0; i < GAMES; i++) {
            var rndNum = RandomUtils.makeRandom(0, MAXRND);
            QUESTIONARR[i] = String.valueOf(rndNum);
            ANSWERARR[i] = NumberUtils.isEven(rndNum);
        }
        GameEngine.run(GAMECONDITION, QUESTIONARR, ANSWERARR);
    }
}
