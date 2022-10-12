package hexlet.code.utils;

public class PrimeUtils {
    /**
     * it gives correct answer if given number prime or not.
     * @param quest given number.
     * @return "yes" or "no".
     */
    public static String isPrime(
            final String quest) {
        int intQuest = Integer.parseInt(quest);
        if (intQuest < 2) {
            return "no";
        }
        for (int i = 2; i < intQuest; i++) {
            if (intQuest % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
