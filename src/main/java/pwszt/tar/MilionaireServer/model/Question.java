package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    private int id;
    private String quest;
    private String[] answers;
    private int correct;

    /**
     * Class Question is used to hold data about question and answers
     *
     * @param id id of Quesion. Must be original
     * @param quest Question text
     * @param answers Answers for question where only one is correct
     * @param correct number of correct answer
     */
    public Question(@JsonProperty("id") int id,
                    @JsonProperty("question") String quest,
                    @JsonProperty("answers") String[] answers,
                    @JsonProperty("correctAnswer") int correct){
        this.id = id;
        this.quest = quest;
        this.answers = answers;
        this.correct = correct;
    }

    /**
     * Get Question id
     * @return Question id
     */
    public int getId() {
        return id;
    }

    /**
     * Get Question question
     * @return Question question
     */
    public String getQuest() {
        return quest;
    }

    /**
     * Get Question answers
     * @return Question answers
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Get number of correct answer
     * @return Question correct answer number
     */
    public int getCorrect() {
        return correct;
    }
}
