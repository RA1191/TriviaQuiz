package com.example.quizapi.services;

import com.example.quizapi.classes.*;
import com.example.quizapi.interfaces.IQuestionService;
import com.example.quizapi.interfaces.ITriviaAPIService;

import java.util.*;

public class QuestionService implements IQuestionService {

    private final ITriviaAPIService triviaAPIService = new TriviaAPIService();
    private final List<Question> currentQuestions = new ArrayList<>();

    public QuestionSetList GetQuestions() throws Exception {
        QuestionSetList newSet = triviaAPIService.GetQuestions();
        if(newSet.amount() != 0){
            currentQuestions.addAll(newSet.questions());
        }
        return newSet;
    }

    public List<AnswerReport> CheckAnswers(List<Answer> answers){
        List<AnswerReport> report = new ArrayList<>();
        for(Answer answer:answers){
            for(Question question: currentQuestions){
                if(answer.getQuestionId().equals(question.getQuestionID())){
                    report.add(new AnswerReport(answer.getQuestionId(), question.CheckAnswer(answer.getAnswer())));
                    break;
                }
            }
        }
        return report;
    }
}
