package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.Question;

import java.util.HashMap;

@Repository("questionDao")
public class QuestionData {
    /**
     * Send question to client
     * @see Question
     * @param question Question to send
     * @return Question in JSON format
     */
    public Question sendQuestion(Question question){
        return question;
    }

    /**
     * Return server answer if given answer is correct
     * @param answer server answer
     * @return serwer anser in JSON format
     */
    public HashMap sendIsCorrect(HashMap answer){
        return answer;
    }
}
