package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.HelloUtils;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class FillingProgressionRangeGame {
    /**
     * number of games.
     */
    public static final int GAMES = 3;
    /**
     * max random number.
     */
    public static final int MAXRND = 100;
    /**
     * max random progression step.
     */
    public static final int MAXSTEP = 9;
    /**
     * max progression line length.
     */
    public static final int PR_LENGTH = 9;
    /**
     * game condition question.
     */
    private static final String GAMECONDITION =
            "What number is missing in the progression?";
    /**
     * start Progression game logic.
     */
    public static void play() {
        String userName = HelloUtils.hello();
        String[] questionList = new String[GAMES];
        String[] answerList = new String[GAMES];
        for (int i = 0; i < GAMES; i++) {
            questionList[i] = makeExpression();
            answerList[i] = getProgressionNum(questionList[i]);
        }
        GameEngine.run(userName, GAMECONDITION, questionList, answerList);
    }
    /**
     * missing number question params.
     * @return missing number question params string.
     */
    public static String makeExpression() {
        StringBuilder sb = new StringBuilder();
        int firstRangeNum = RandomUtils.makeRandom(MAXRND);
        int stepRange = RandomUtils.makeRandom(MAXSTEP) + 1;
        int indexedRange = RandomUtils.makeRandom(PR_LENGTH);
        for (int i = 0; i <= PR_LENGTH; i++) {
            if (i == indexedRange) {
                sb.append("..");
                sb.append(" ");
            } else {
                sb.append(firstRangeNum);
                sb.append(" ");
            }
            firstRangeNum += stepRange;
        }
        return sb.toString();
    }
    /**
     * get missing num from progression.
     * @param quest progression string.
     * @return correct answer.
     */
    private static String getProgressionNum(final String quest) {
        var questArray = quest.split(" ");
        var correctAnswer = "";
        var tempList = new ArrayList<>();
        var index = 0;
        for (Object o : questArray) {
            if (!o.equals(" ")) {
                tempList.add(o);
            }
        }
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).equals("..")) {
                index = i;
            }
        }
        correctAnswer = Integer.toString(getAnswer(index, tempList));
        return correctAnswer;
    }
    private static int getAnswer(
            final int index, final List<Object> stringArr
    ) {
        int intAnswer;
        int index1;
        int index2;
        int length = stringArr.size() - 1;
        switch (index) {
            case 0 -> {
                index2 = Integer.parseInt(String.valueOf(stringArr.get(2)));
                index1 = Integer.parseInt(String.valueOf(stringArr.get(1)));
                intAnswer = index1 - (index2 - index1);
            }
            case PR_LENGTH -> {
                index2 = Integer
                        .parseInt(String.valueOf(stringArr.get(length - 2)));
                index1 = Integer
                        .parseInt(String.valueOf(stringArr.get(length - 1)));
                intAnswer = index1 + (index1 - index2);
            }
            default -> {
                index2 = Integer
                        .parseInt(String.valueOf(stringArr.get(index + 1)));
                index1 = Integer
                        .parseInt(String.valueOf(stringArr.get(index - 1)));
                intAnswer = (index2 + index1) / 2;
            }
        }
        return intAnswer;
    }
}

