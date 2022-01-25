package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionCheckBody {
    private int questionId;
    private int fileId;
    private int answer;

    /**
     * Class holding data nessesery for client to check if Question answer is correct
     * @see Question
     * @param questionId id of question
     * @param fileId id of file/number of question in array
     * @param answer id of given answer
     */
    public QuestionCheckBody(@JsonProperty("questionId") int questionId,
                             @JsonProperty("fileId") int fileId,
                             @JsonProperty("answer") int answer){

        this.questionId = questionId;
        this.fileId = fileId;
        this.answer = answer;
    }

    /**
     * Get QuestionCheckBody id
     * @return QuestionCheckBody id
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Get QuestionCheckBody file/question number
     * @return QuestionCheckBody file/question number
     */
    public int getFileId() {
        return fileId;
    }

    /**
     * Get QuestionCheckBody number of answer
     * @return QuestionCheckBody number of answer
     */
    public int getAnswer() {
        return answer;
    }
}
