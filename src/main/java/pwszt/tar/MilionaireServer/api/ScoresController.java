package pwszt.tar.MilionaireServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwszt.tar.MilionaireServer.model.ScoreLabel;
import pwszt.tar.MilionaireServer.service.ScoreService;

import java.util.HashMap;

/**
 * Class used to control Score requests
 * @see ScoreLabel
 */
@RequestMapping("millionaire/scores/")
@RestController
public class ScoresController {
    private final ScoreService scoreService;

    @Autowired
    public ScoresController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("get")
    public HashMap getScores(){
        return scoreService.getScores();
    }

    @PostMapping("add")
    public ScoreLabel addScore(ScoreLabel scoreLabel){
        return scoreService.addScore(scoreLabel);
    }
}
