package hexlet.code.games;


import hexlet.code.GameEngine;
import hexlet.code.utils.PrimeUtils;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prime {
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
     * start Prime game logic.
     */
    public static void play() {
        String gameQuest =
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        System.out.print(WELCOME);
        List<List<Object>> rndList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            rndList.add(Collections.singletonList(
                    RandomUtils.makeRandom(MAXRND)));
            answerList.add(PrimeUtils.isPrime(
                    String.valueOf(rndList.get(i).get(0))));
        }
        var engine = new GameEngine(
                gameQuest,
                rndList,
                answerList);
        GameEngine.run(engine);
    }
}

