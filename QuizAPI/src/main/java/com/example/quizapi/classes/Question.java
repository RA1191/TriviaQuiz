package com.example.quizapi.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Question {
    private UUID questionID;
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public Question(String type, String difficulty, String category, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.questionID = UUID.randomUUID();
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public boolean CheckAnswer(String answer){
        return correctAnswer.equals(answer);
    }
}
