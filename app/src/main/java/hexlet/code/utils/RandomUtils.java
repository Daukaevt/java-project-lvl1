package hexlet.code.utils;

import java.util.Random;

public class RandomUtils {
    /**
     make random int 0..MAXRND.
     * @param maxRnd max randoms range int.
     * @param minRnd min randoms range int.
     * @return random int from min to max.
     */
    public static int makeRandom(final int minRnd, final int maxRnd) {
        Random random = new Random(); //instance of random class
        return random.nextInt(minRnd, maxRnd);
    }
}
