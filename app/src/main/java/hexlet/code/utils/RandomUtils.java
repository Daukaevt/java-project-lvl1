package hexlet.code.utils;

import java.util.Random;

public class RandomUtils {
    /**
     * make random int 0..MAXRND.
     * @param maxRnd max randoms range int.
     * @return random int
     */
    public static int makeRandom(final int maxRnd) {
        Random rnd = new Random(); //instance of random class
        return rnd.nextInt(0, maxRnd);
    }
}
