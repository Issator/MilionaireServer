package pwszt.tar.MilionaireServer.dao;

import org.springframework.stereotype.Repository;
import pwszt.tar.MilionaireServer.model.Player;

import java.util.HashMap;

/**
 * Class used to return PlayerService answers
 * @see pwszt.tar.MilionaireServer.service.PlayerService
 */
@Repository("playerDao")
public class PlayerData {

    /**
     * Return Player as an server answer
     * @param player Player to send
     * @return Player information
     */
    public Player returnPlayer(Player player){
        return player;
    }

    /**
     * Return answer if given player has been found and deleted
     * @param answer Server generated answer
     * @return Server answer
     */
    public HashMap deletePlayerAnswer(HashMap answer){
        return answer;
    }

}
