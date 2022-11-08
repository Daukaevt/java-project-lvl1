package hexlet.code.utils;

import java.util.Arrays;

public class NumberUtils {
    /**
     * check if given nuber is even.
     * @param num given number.
     * @return 'yes' or 'no' answer.
     */
    public static boolean isEven(final int num) {
        return num % 2 == 0 ? true : false;
    }

    /**
     * make correct answer.
     * @param firstNum first number of the expression.
     * @param secondNum second number of the expression.
     * @return solution string.
     */
    public static String findGCD(final int firstNum, final int secondNum) {
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
    public static int[] makeProgression(int firstRangeNum, int stepRange, int rangeSize) {
        // declares an Array of integers.
        int[] progressionArr;
        progressionArr = new int[rangeSize];
        for (int i = 0; i < rangeSize; i++) {
            progressionArr[i] = firstRangeNum + stepRange * i;
        }
        return progressionArr;
    }
}

