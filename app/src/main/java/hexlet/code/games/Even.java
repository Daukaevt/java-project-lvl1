package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Even {
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
     * start Even game logic.
     */
    public static void play() {
        String gameQuest =
                "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.print(WELCOME);
        List<String> rndList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            rndList.add(String.valueOf(RandomUtils.makeRandom(MAXRND)));
            answerList.add(correctAnswer(Integer.parseInt(rndList.get(i))));
        }
        var engine = new GameEngine(
                gameQuest,
                rndList,
                answerList);
        GameEngine.run(engine);
    }
    private static String correctAnswer(final int nextRND) {
        return nextRND % 2 == 0 ? "yes" : "no";
    }
}
