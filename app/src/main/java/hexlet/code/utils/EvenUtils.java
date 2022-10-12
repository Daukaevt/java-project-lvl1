package hexlet.code.utils;

public class EvenUtils {
    /**
     * check if given nuber is even.
     * @param num given number.
     * @return 'yes' or 'no' answer.
     */
    public static String isEven(final int num) {
        return num % 2 == 0 ? "yes" : "no";
    }
}
