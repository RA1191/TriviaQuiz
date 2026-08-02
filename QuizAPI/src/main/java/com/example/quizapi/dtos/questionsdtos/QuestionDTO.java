package com.example.quizapi.dtos.questionsdtos;

import java.util.List;
import java.util.UUID;

public record QuestionDTO(UUID questionId, String type, String difficulty, String category, String question, List<String> answers) {}