package com.example.quizapi.dtos.answerdtos;

import java.util.UUID;

public record AnswerDTO(UUID questionId, String answer) {}