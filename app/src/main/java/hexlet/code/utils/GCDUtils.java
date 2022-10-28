package hexlet.code.utils;

import java.util.Arrays;

public class GCDUtils {
    /**
     * make correct answer.
     * @param firstNum first number of the expression.
     * @param secondNum second number of the expression.
     * @return solution string.
     */
    public static String makeSolution(final int firstNum, final int secondNum) {
        int[] arr = {firstNum, secondNum};
        Arrays.sort(arr);
        var remainder = arr[0];
        do {
            if (remainder == 0) {
                break;
            }
            remainder = arr[1] % arr[0];
            arr[1] = arr[0];
            arr[0] = remainder;
        } while (remainder != 0);
        return String.valueOf(arr[1]);
    }
}
