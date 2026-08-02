package com.example.quizapi.interfaces;

import com.example.quizapi.classes.*;

import java.util.List;
import java.util.UUID;

public interface IQuestionService {
    QuestionSetList GetQuestions() throws Exception;
    List<AnswerReport> CheckAnswers(List<Answer> answers);
}
