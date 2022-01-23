package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.ScoreLabel;

import java.util.HashMap;

@Repository("scoreDao")
public class ScoreData {

    public HashMap getScores(HashMap answer){
        return answer;
    }

    public ScoreLabel returnScore(ScoreLabel scoreLabel){
        return scoreLabel;
    }
}
