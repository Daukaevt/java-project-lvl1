package hexlet.code.utils;

public class PrimeUtils {
    /**
     * it gives correct answer if given number prime or not.
     * @param quest given number.
     * @return "yes" or "no".
     */
    public static String isPrime(
            final int quest) {
        if (quest < 2) {
            return "no";
        }
        for (int i = 2; i < quest; i++) {
            if (quest % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
