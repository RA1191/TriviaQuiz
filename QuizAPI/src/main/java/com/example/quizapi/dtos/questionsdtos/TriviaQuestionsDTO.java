package com.example.quizapi.dtos.questionsdtos;

import java.util.List;

public record TriviaQuestionsDTO(int response_code, List<TriviaQuestionDTO> results) {}