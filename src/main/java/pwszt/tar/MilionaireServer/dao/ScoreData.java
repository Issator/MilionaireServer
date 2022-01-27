package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.ScoreLabel;

import java.util.HashMap;

/**
 * Class used to return ScoreService answers
 * @see pwszt.tar.MilionaireServer.service.ScoreService
 */
@Repository("scoreDao")
public class ScoreData {

    /**
     * return List of scores from database
     * @see ScoreLabel
     * @param answer server answer
     * @return List of scores in JSON format
     */
    public HashMap getScores(HashMap answer){
        return answer;
    }

    /**
     * return given Player score
     * @see ScoreLabel
     * @param scoreLabel score from server
     * @return score in JSON format
     */
    public ScoreLabel returnScore(ScoreLabel scoreLabel){
        return scoreLabel;
    }

    /**
     * Return server answer id score was deleted successfully
     * @param serverAnswer answer from server about score
     * @return answer in JSON
     */
    public HashMap deleteScoreAnswer(HashMap<String, String> serverAnswer) {
        return serverAnswer;
    }
}
