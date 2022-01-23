package pwszt.tar.MilionaireServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwszt.tar.MilionaireServer.dao.ScoreData;
import pwszt.tar.MilionaireServer.model.ScoreLabel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ScoreService {
    private final ScoreData scoreData;
    private final List<ScoreLabel> ScoresDB = new ArrayList<>();

    @Autowired
    public ScoreService(ScoreData scoreData) {
        List<ScoreLabel> scoresFromFile = new ArrayList<>();
        scoresFromFile.addAll(getScoresFromFile());
        this.scoreData = scoreData;

        if(!scoresFromFile.isEmpty()){
            this.ScoresDB.addAll(scoresFromFile);
        }
    }

    public HashMap getScores(){
        HashMap serverAnswer = new HashMap();
        serverAnswer.put("scores",ScoresDB);
        return  scoreData.getScores(serverAnswer);

    }

    public ScoreLabel addScore(ScoreLabel score){
        ScoresDB.add(score);
        addScoreToFile(score);
        return scoreData.returnScore(score);
    }

    public int addScoreToFile(ScoreLabel scoreLabel){
        try {
            FileWriter fw = new FileWriter("baza/scores.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            String toSave = scoreLabel.getNick() + ";" +
                            scoreLabel.getScore();

            out.println(toSave);

            out.close();
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public List<ScoreLabel> getScoresFromFile(){
        List<ScoreLabel> scoreList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("baza/scores.csv")
            );
            String line;
            while ((line= br.readLine())!=null){
                String [] data = line.split(";");
                ScoreLabel scoreLabel = new ScoreLabel(data[0],Integer.parseInt(data[1]));
                scoreList.add(scoreLabel);
            }
        } catch (FileNotFoundException e) {
            System.out.println("NIE ZNALEZIONO PLIKU Z WYNIKAMI");
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.out.println("BLAD ODCZYTU PLIKU Z WYNIKAMI");
            e.printStackTrace();
            return null;
        }
        return scoreList;
    }
}
