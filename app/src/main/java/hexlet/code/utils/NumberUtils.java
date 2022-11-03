package hexlet.code.utils;

import java.util.Arrays;

public class NumberUtils {
    /**
     * check if given nuber is even.
     * @param num given number.
     * @return 'yes' or 'no' answer.
     */
    public static String isEven(final int num) {
        return num % 2 == 0 ? "yes" : "no";
    }

    /**
     * max progression line length.
     */
    public static final int PR_LENGTH = 9;
    /**
     * missing number question params.
     * @param firstRangeNum first number in progression.
     * @param stepRange difference between two nearest numbers in progression.
     * @param indexedRange index of missing number in progression.
     * @return missing number question params string.
     */
    public static String makeExpression(int firstRangeNum, int stepRange, int indexedRange) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= PR_LENGTH; i++) {
            if (i == indexedRange) {
                sb.append(".. ");
            } else {
                sb.append(firstRangeNum);
                sb.append(" ");
            }
            firstRangeNum += stepRange;
        }
        return sb.toString();
    }
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
