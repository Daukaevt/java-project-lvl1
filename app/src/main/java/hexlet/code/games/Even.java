package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.EvenUtils;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        String gameQuest =
                "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String userName = HelloUtils.hello();
        System.out.println(gameQuest);
        List<List<Object>> rndList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            rndList.add(Collections.singletonList(
                    String.valueOf(RandomUtils.makeRandom(MAXRND))));
            answerList.add(EvenUtils.isEven(
                    Integer.parseInt(rndList.get(i).get(0).toString())));
        }
        var engine = new GameEngine(
                userName,
                rndList,
                answerList);
        GameEngine.run(engine);
    }
}
