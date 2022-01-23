package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.Player;

import java.util.HashMap;

@Repository("playerDao")
public class PlayerData {

    public Player returnPlayer(Player player){
        return player;
    }

    public HashMap deletePlayerAnswer(HashMap answer){
        return answer;
    }

}
