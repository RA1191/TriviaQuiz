package com.example.quizapi.converters;

import com.example.quizapi.classes.Question;
import com.example.quizapi.classes.QuestionSetList;
import com.example.quizapi.dtos.questionsdtos.QuestionDTO;
import com.example.quizapi.dtos.questionsdtos.QuestionsDTO;
import com.example.quizapi.dtos.questionsdtos.TriviaQuestionDTO;
import com.example.quizapi.dtos.questionsdtos.TriviaQuestionsDTO;

import java.util.*;

public class QuestionConverter {
    static public List<Question> TriviaQuestionsDTOToList(TriviaQuestionsDTO triviaQuestionsDTO){
        List<Question> questions = new ArrayList<>();
        for(TriviaQuestionDTO triviaQuestionDTO: triviaQuestionsDTO.results()){
            questions.add(TriviaQuestionDTOToQuestion(triviaQuestionDTO));
        }
        return questions;
    }

    static  public Question TriviaQuestionDTOToQuestion(TriviaQuestionDTO triviaQuestionDTO){
        return new Question(triviaQuestionDTO.type(),
                triviaQuestionDTO.difficulty(),
                triviaQuestionDTO.category(),
                triviaQuestionDTO.question(),
                triviaQuestionDTO.correct_answer(),
                triviaQuestionDTO.incorrect_answers()
        );
    }

    static public QuestionsDTO QuestionSetListToQuestionsDTO(QuestionSetList questionSetList){
        List<QuestionDTO> questions = new ArrayList<>();
        for (Question question: questionSetList.questions()){
            questions.add(QuestionToQuestionDTO(question));
        }
        return new QuestionsDTO(questions);
    }

    static public QuestionDTO QuestionToQuestionDTO(Question question){
        List<String> allAnswers = new ArrayList<>();
        allAnswers.addAll(question.getIncorrectAnswers());
        allAnswers.add(question.getCorrectAnswer());
        Collections.shuffle(allAnswers);
        return new QuestionDTO(question.getQuestionID(), question.getType(), question.getDifficulty(), question.getCategory(), question.getQuestion(), allAnswers);
    }
}
