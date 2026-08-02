package com.example.quizapi.dtos.questionsdtos;

import java.util.List;

public record TriviaQuestionDTO(String type, String difficulty, String category, String question, String correct_answer, List<String> incorrect_answers) {}