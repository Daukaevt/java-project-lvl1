package hexlet.code.utils;


public class ProgressionUtils {
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
}
