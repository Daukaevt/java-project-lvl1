package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Progression {
    /**
     * welcome.
     */
    private static final String WELCOME = "Welcome to the Brain Games!"
            + "\nMay I have your name? ";
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
     * start Progression game logic.
     */
    public static void play() {
        String gameQuest =
                "What number is missing in the progression?";
        System.out.print(WELCOME);
        List<String> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < GAMES; i++) {
            questionList.add(makeExpression());
            answerList.add(getProgressionNum1(questionList.get(i)));
        }
        var engine = new GameEngine(
                gameQuest,
                questionList,
                answerList);
        GameEngine.run(engine);
    }
    /**
     * missing number question params.
     * @return missing number question params string.
     */
    public static String makeExpression() {
        int firstRangeNum = Integer.parseInt(String.valueOf(RandomUtils.makeRandom(MAXRND)));
        int stepRange = Integer.parseInt(String.valueOf(RandomUtils.makeRandom(MAXSTEP))) + 1;
        int indexedRange = Integer.parseInt(String.valueOf(RandomUtils.makeRandom(PR_LENGTH)));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= PR_LENGTH; i++) {
            if (i == indexedRange) {
                stringBuilder.append(" ..");
            } else {
                stringBuilder.append(" ").append(firstRangeNum);
            }
            firstRangeNum += stepRange;
        }
        return stringBuilder.substring(1);
    }
    /**
     * get missing num from progression.
     * @param quest progression string.
     * @return correct answer.
     */
    private static String getProgressionNum1(final String quest) {
        var correctAnswer = "";
        var stringArr = quest.split(" ");
        var index = 0;
        int length = stringArr.length;
        for (int i = 0; i < length; i++) {
            if (stringArr[i].equals("..")) {
                index = i;
            }
        }
        correctAnswer = Integer.toString(getAnswer(index, stringArr));
        return correctAnswer;
    }
    private static int getAnswer(final int index, final String[] stringArr) {
        int intAnswer;
        int index1;
        int index2;
        int length = stringArr.length - 1;
        switch (index) {
            case 0 -> {
                index2 = Integer.parseInt(stringArr[2]);
                index1 = Integer.parseInt(stringArr[1]);
                intAnswer = index1 - (index2 - index1);
            }
            case PR_LENGTH -> {
                index2 = Integer.parseInt(stringArr[length - 2]);
                index1 = Integer.parseInt(stringArr[length - 1]);
                intAnswer = index1 + (index1 - index2);
            }
            default -> {
                index2 = Integer.parseInt(stringArr[index + 1]);
                index1 = Integer.parseInt(stringArr[index - 1]);
                intAnswer = (index2 + index1) / 2;
            }
        }
        return intAnswer;
    }
}

