package com.example.quizapi.dtos.answerdtos;

import java.util.UUID;

public record AnswerReportDTO(UUID questionId, boolean correct) {}