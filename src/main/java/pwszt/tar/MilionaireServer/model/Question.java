package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    private int id;
    private String quest;
    private String[] answers;

    public Question(@JsonProperty("id") int id,
                    @JsonProperty("question") String quest,
                    @JsonProperty("answers") String[] answers){
        this.id = id;
        this.quest = quest;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public String getQuest() {
        return quest;
    }

    public String[] getAnswers() {
        return answers;
    }
}
