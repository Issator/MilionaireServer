package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    private int id;
    private String quest;
    private String[] answers;
    private int correct;

    public Question(@JsonProperty("id") int id,
                    @JsonProperty("question") String quest,
                    @JsonProperty("answers") String[] answers,
                    @JsonProperty("correctAnswer") int correct){
        this.id = id;
        this.quest = quest;
        this.answers = answers;
        this.correct = correct;
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

    public int getCorrect() {
        return correct;
    }
}
