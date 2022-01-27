package pwszt.tar.MilionaireServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwszt.tar.MilionaireServer.dao.QuestionData;
import pwszt.tar.MilionaireServer.model.Question;
import pwszt.tar.MilionaireServer.model.QuestionCheckBody;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * Service of all Question data
 * @see Question
 * @see pwszt.tar.MilionaireServer.api.QuestionContoller
 * @see QuestionData
 */
@Service
public class QuestionService {
    private final QuestionData questionData;

    @Autowired
    public QuestionService(QuestionData questionData){
        this.questionData = questionData;
    }

    /**
     * Load random Question from selected file
     * @see Question
     * @param id file number
     * @return random Question
     */
    public Question loadQuestion(int id){
        try {
            Random random = new Random();
            BufferedReader br = new BufferedReader(
                    new FileReader("baza/questions/" + id + ".csv")
            );

            String line;
            int rnd = random.nextInt(10) + 1;

            // Zignoruj pierwsza linie
            line=br.readLine();
            line=null;

            while ((line=br.readLine())!=null)
            {
                String [] data = line.split(";");
                int qId = Integer.parseInt(data[0]);
                if (qId == rnd)
                {

                    String [] ans = {data[2],data[3],data[4],data[5]};
                    int correct = Integer.parseInt(data[6]);
                    Question question = new Question(qId,data[1],ans,correct);
                    br.close();
                    return questionData.sendQuestion(question);
                }
            }
        }catch (IOException e){
            return null;
        }

        return null;
    }

    /**
     * Check if given answer is correct
     * @see Question
     * @see QuestionCheckBody
     * @param answer QuestionCheckBody of given answer
     * @return false or true server answer
     */
    public HashMap checkQuestion(QuestionCheckBody answer) {

        HashMap<String, String> serverAnswer = new HashMap<>();
        String isCorrect = "false";
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("baza/questions/" + answer.getFileId() + ".csv")
            );

            String line;

            // Zignoruj pierwsza linie
            line=br.readLine();
            line=null;

            while ((line=br.readLine())!=null)
            {
                String [] data = line.split(";");
                int qId = Integer.parseInt(data[0]);
                if (qId == answer.getQuestionId())
                {
                    int correct = Integer.parseInt(data[6]);
                    br.close();

                    if(correct == answer.getAnswer()){
                        isCorrect = "true";
                    }else{
                        isCorrect = "false";
                    }

                    br.close();
                    serverAnswer.put("isCorrect",isCorrect);
                    return questionData.sendIsCorrect(serverAnswer);
                }
            }


        }catch (IOException e){
            System.out.println("CHECK QUESTION ERROR");
            return null;
        }

        return null;
    }

}
