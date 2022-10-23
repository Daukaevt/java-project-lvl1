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
     * start Even game logic.
     */
    public static void play() {
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionList[i] = String.valueOf(RandomUtils.makeRandom(MAXRND));
            answerList[i] = EvenUtils.isEven(Integer.parseInt(questionList[i]));
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }
}
