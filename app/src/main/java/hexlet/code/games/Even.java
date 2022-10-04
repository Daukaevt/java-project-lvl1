package hexlet.code.games;


import hexlet.code.Cli;
import hexlet.code.EngineData;
import hexlet.code.GameEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Even {
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
        String welcome = Cli.welcome();
        String gameQuest =
                "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.print(welcome);
        List<String> rndList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            rndList.add(random());
            answerList.add(correctAnswer(Integer.parseInt(rndList.get(i))));
        }
        var engine = new EngineData(
                gameQuest,
                rndList,
                answerList);
        GameEngine.getFullString(engine);
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
