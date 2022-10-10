package hexlet.code.games;

import hexlet.code.GameEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            rndList.add(random());
            answerList.add(correctAnswer(Integer.parseInt(rndList.get(i))));
        }
        var engine = new GameEngine(
                gameQuest,
                rndList,
                answerList);
        GameEngine.run(engine);
    }
    /**
     * Even game if even question.
     * @return if even question String.
     */
    public static String random() {
        Random rnd = new Random(); //instance of random class
        return Integer.toString(rnd.nextInt(0, MAXRND));
    }
    private static String correctAnswer(final int nextRND) {
        return nextRND % 2 == 0 ? "yes" : "no";
    }
}
