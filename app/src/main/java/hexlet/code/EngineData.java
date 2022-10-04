package hexlet.code;

import java.util.List;

public class EngineData {

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
    public EngineData(
            final String quest,
            final List<String> listQuest,
            final List<String> listAnswer
    ) {
        this.gameQuest = quest;
        this.questList = listQuest;
        this.answerList = listAnswer;
    }
    public String getGameQuest() {
        return this.gameQuest;
    }
    public List<String> getQuestList() {
        return this.questList;
    }
    public List<String> getAnswerList() {
        return this.answerList;
    }
}
