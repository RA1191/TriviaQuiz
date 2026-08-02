package com.example.quizapi.classes;

import java.util.UUID;

public record AnswerReport(UUID questionId, boolean correct) {}