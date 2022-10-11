package hexlet.code.utils;

import java.util.Random;

public class RandomUtils {
     /**
     * make random int 0..MAXRND.
     * @return random int
     */
    public static String makeRandom(int maxRnd) {
        Random rnd = new Random(); //instance of random class
        return Integer.toString(rnd.nextInt(0, maxRnd));
    }
}
