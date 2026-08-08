package com.example.quizapi.classes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QuestionTests {

    Question question = new Question("", "", "", "", "true", null);

    @Test
    void CheckAnswerIsCorrect(){
        String answer = "true";

        boolean actual = question.CheckAnswer(answer);

        assertTrue(actual);
    }

    @Test
    void CheckAnswerIsFalse(){
        String answer = "";

        boolean actual = question.CheckAnswer(answer);

        assertFalse(actual);
    }
}
