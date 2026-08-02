package com.example.quizapi.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Answer {
    private UUID questionId;
    private String answer;

    public Answer(UUID questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

}
