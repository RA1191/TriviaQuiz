package com.example.quizapi.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetQuestionsSet {
    private int amount;
    private String category;
    private String difficulty;
    private String type;
    private UUID sessionId;

    public GetQuestionsSet(int amount, String category, String difficulty, String type, UUID sessionId) {
        this.amount = amount;
        this.category = category;
        this.difficulty = difficulty;
        this.type = type;
        this.sessionId = sessionId;
    }
}
