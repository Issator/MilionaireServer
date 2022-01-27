package pwszt.tar.MilionaireServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwszt.tar.MilionaireServer.dao.ScoreData;
import pwszt.tar.MilionaireServer.model.ScoreLabel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * service of all Score data
 * @see ScoreLabel
 * @see pwszt.tar.MilionaireServer.api.ScoresController
 * @see ScoreData
 */
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

    /**
     * Get all scores form server
     * @return score List
     */
    public HashMap getScores(){
        HashMap serverAnswer = new HashMap();
        serverAnswer.put("scores",ScoresDB);
        return  scoreData.getScores(serverAnswer);

    }

    /**
     * add score to server database
     * @param score score to add
     * @return server answer od conformed add
     */
    public ScoreLabel addScore(ScoreLabel score){
        ScoresDB.add(score);
        addScoreToFile(score);
        return scoreData.returnScore(score);
    }

    /**
     * save score in database file. If added successfully, function will return 0. In case of error, will return -1
     * @param scoreLabel score to save
     * @return 0 if added, -1 if error occurred
     */
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

    /**
     * Get scores from database file and save it on server database
     * @return ArrayList of scores
     */
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

    /**
     * Update database Scores file with server database
     */
    public void updateScoreFile(){
        try {
            FileWriter fw = new FileWriter("baza/scores.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            for (ScoreLabel scoreLabel : ScoresDB){
                String toSave = scoreLabel.getNick() + ";" +
                        scoreLabel.getScore();

                out.println(toSave);
            }
            out.close();
            bw.close();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public HashMap deleteScore(ScoreLabel scoreLabel){
        HashMap<String, String> serverAnswer = new HashMap<>();

        Optional<ScoreLabel> toDeleteScoreLabel;
        toDeleteScoreLabel = ScoresDB.stream()
                                     .filter(score ->
                                             score.getNick().equals(scoreLabel.getNick()) &&
                                             score.getScore() == scoreLabel.getScore())
                                     .findFirst();

        if(toDeleteScoreLabel.isEmpty()){
            serverAnswer.put("isExist","false");
            serverAnswer.put("isDeleted","false");
        } else {
            ScoresDB.remove(toDeleteScoreLabel.get());
            serverAnswer.put("isExist","true");
            serverAnswer.put("isDeleted","true");
            updateScoreFile();
        }
        return scoreData.deleteScoreAnswer(serverAnswer);
    }
}
