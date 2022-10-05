package hexlet.code;

import java.util.List;

public final class EngineData {

    /**
     * game quest data.
     */
    private final String gameQuest;
    /**
     *  list of 3 quests.
     */
    private List<String> questList;
    /**
     * list of 3 answers.
     */
    private List<String> answerList;

    /**
     * data class.
     * @param quest game question.
     * @param listQuest list of game question params.
     * @param listAnswer list of game answers.
     */
    public EngineData(
            final String quest,
            final List<String> listQuest,
            final List<String> listAnswer
    ) {
        this.gameQuest = quest;
        this.questList = listQuest;
        this.answerList = listAnswer;
    }

    /**
     * game question.
     * @return game question string.
     */
    public String getGameQuest() {
        return this.gameQuest;
    }

    /**
     * list of game question params.
     * @return quest list.
     */
    public List<String> getQuestList() {
        return this.questList;
    }

    /**
     * list of game answers.
     * @return answers list.
     */
    public List<String> getAnswerList() {
        return this.answerList;
    }
}
