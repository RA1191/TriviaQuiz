package com.example.quizapi.controllers;

import com.example.quizapi.classes.Answer;
import com.example.quizapi.classes.QuestionSetList;
import com.example.quizapi.converters.AnswerConverter;
import com.example.quizapi.converters.QuestionConverter;
import com.example.quizapi.dtos.answerdtos.AnswerReportsDTO;
import com.example.quizapi.dtos.answerdtos.AnswersDTO;
import com.example.quizapi.dtos.questionsdtos.QuestionsDTO;
import com.example.quizapi.interfaces.IQuestionService;
import com.example.quizapi.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TriviaController {
    final IQuestionService questionService = new QuestionService();

    @GetMapping
    @RequestMapping("/questions")
    public QuestionsDTO GetQuestions() throws Exception {;
        QuestionSetList questionSetList = questionService.GetQuestions();
        return QuestionConverter.QuestionSetListToQuestionsDTO(questionSetList);
    }

    @PostMapping
    @RequestMapping("/checkanswers")
    public AnswerReportsDTO CheckAnswers(@RequestBody AnswersDTO answersDTO){
        List<Answer> answers = AnswerConverter.AnswersDTOToList(answersDTO);
        return AnswerConverter.AnswerReportListToAnswerReportsDTO(questionService.CheckAnswers(answers));
    }
}
