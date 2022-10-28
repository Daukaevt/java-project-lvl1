package hexlet.code.utils;

public class CalcUtils {
    /**
     * result of expression.
     */
    private static int result;

    /**
     * Calc game make expression logic.
     * @param firstNum first number of the expression.
     * @param mathOperation expression math operator id.
     * @param secondNum second number of the expression.
     * @return question string.
     */
    public static String makeExpression(
            final int firstNum,
            final int mathOperation,
            final int secondNum) {
        var sb = new StringBuilder();
        sb.append(firstNum).append(" ");
        char mathOperator;
        switch (mathOperation) {
            case 0 -> {
                mathOperator = '+';
                result = firstNum + secondNum;
            }
            case 1 -> {
                mathOperator = '-';
                result = firstNum - secondNum;
            }
            case 2 -> {
                mathOperator = '*';
                result = firstNum * secondNum;
            }
            default -> throw new IllegalStateException(
                    "Unexpected value: " + mathOperation);
        }
        sb.append(mathOperator).append(" ");
        sb.append(secondNum);
        return sb.toString();
    }

    /**
     * get result.
     * @return result.
     */
    public static int makeSolution() {
        return result;
    }
}
