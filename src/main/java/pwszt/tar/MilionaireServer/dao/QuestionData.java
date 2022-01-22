package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.Question;

import java.util.HashMap;

@Repository("questionDao")
public class QuestionData {
    public Question sendQuestion(Question question){
        return question;
    }

    public HashMap sendIsCorrect(HashMap answer){
        return answer;
    }
}
