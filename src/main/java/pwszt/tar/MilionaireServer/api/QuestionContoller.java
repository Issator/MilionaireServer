package pwszt.tar.MilionaireServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwszt.tar.MilionaireServer.model.Question;
import pwszt.tar.MilionaireServer.model.QuestionCheckBody;
import pwszt.tar.MilionaireServer.service.QuestionService;

import java.util.HashMap;

@RequestMapping("millionaire/")
@RestController
public class QuestionContoller {

    private final QuestionService questionService;

    @Autowired
    public QuestionContoller(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping(path = "getQuestion/{id}")
    public Question getQuestionById(@PathVariable("id") int id){
        return  questionService.loadQuestion(id);
    }

    @PostMapping(path = "checkQuestion")
    public HashMap checkQuestion(QuestionCheckBody questionCheckBody){
        return questionService.checkQuestion(questionCheckBody);
    }

}
