package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.ScoreLabel;

import java.util.HashMap;

@Repository("scoreDao")
public class ScoreData {

    /**
     * return List of scores from database
     * @see ScoreLabel
     * @param answer serwe answer
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
}
