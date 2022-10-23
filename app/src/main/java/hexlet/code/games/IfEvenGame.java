package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.EvenUtils;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;

public class IfEvenGame {
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
        String userName = HelloUtils.hello();
        for (int i = 0; i < GAMES; i++) {
            QUESTIONARR[i] = String.valueOf(RandomUtils.makeRandom(MAXRND));
            ANSWERARR[i] = EvenUtils.isEven(Integer.parseInt(QUESTIONARR[i]));
        }
        GameEngine.run(userName, GAMECONDITION, QUESTIONARR, ANSWERARR);
    }
}
