package com.example.quizapi.interfaces;

import com.example.quizapi.classes.QuestionSetList;

import java.util.UUID;

public interface ITriviaAPIService {
    QuestionSetList GetQuestions() throws Exception;
}
