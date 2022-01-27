package pwszt.tar.MilionaireServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwszt.tar.MilionaireServer.model.Player;
import pwszt.tar.MilionaireServer.model.PlayerLoginBody;
import pwszt.tar.MilionaireServer.service.PlayerService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Class used to Control Player requests
 * @see Player
 * @see PlayerService
 */
@RequestMapping("millionaire/player/")
@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping(path = "getAll")
    public List getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping(path = "add")
    public Player addPlayer(PlayerLoginBody playerLoginBody){
        return playerService.addPlayer(playerLoginBody);
    }

    @PostMapping(path = "get")
    public Optional<Player> getPlayerByLoginBody(PlayerLoginBody playerLoginBody){
        return playerService.getPlayerByLoginBody(playerLoginBody);
    }

    @GetMapping(path = "delete/{id}")
    public HashMap deletePlayerById(@PathVariable("id") UUID id){
        return playerService.deletePlayerById(id);
    }

    @PutMapping(path = "/edit")
    public Player updatePlayer(Player player){
        return playerService.updatePlayer(player);
    }

}
