package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionCheckBody {
    private int questionId;
    private int fileId;
    private int answer;

    public QuestionCheckBody(@JsonProperty("questionId") int questionId,
                             @JsonProperty("fileId") int fileId,
                             @JsonProperty("answer") int answer){

        this.questionId = questionId;
        this.fileId = fileId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getFileId() {
        return fileId;
    }

    public int getAnswer() {
        return answer;
    }
}
