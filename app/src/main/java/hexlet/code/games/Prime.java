package hexlet.code.games;


import hexlet.code.GameEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<String> rndList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            rndList.add(random());
            answerList.add(checkIfPrime(rndList.get(i)));
        }
        var engine = new GameEngine(
                gameQuest,
                rndList,
                answerList);
        GameEngine.run(engine);
    }
    /**
     * random number 0..MAXRND.
     * @return question String.
     */
    public static String random() {
        Random rnd = new Random();
        return Integer.toString(rnd.nextInt(0, MAXRND));
    }
    /**
     * it gives correct answer if given number prime or not.
     * @param quest given number.
     * @return "yes" or "no".
     */
    public static String checkIfPrime(
            final String quest) {
        int intQuest = Integer.parseInt(quest);
        for (int i = 2; i < intQuest; i++) {
            if (intQuest % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}

