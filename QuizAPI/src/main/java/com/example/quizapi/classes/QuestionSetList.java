package com.example.quizapi.classes;

import java.util.List;

public record QuestionSetList(int amount, List<Question> questions) {
}
