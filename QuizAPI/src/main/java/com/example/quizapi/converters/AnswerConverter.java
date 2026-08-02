package com.example.quizapi.converters;

import com.example.quizapi.classes.Answer;
import com.example.quizapi.classes.AnswerReport;
import com.example.quizapi.dtos.answerdtos.AnswerDTO;
import com.example.quizapi.dtos.answerdtos.AnswerReportDTO;
import com.example.quizapi.dtos.answerdtos.AnswerReportsDTO;
import com.example.quizapi.dtos.answerdtos.AnswersDTO;

import java.util.ArrayList;
import java.util.List;

public class AnswerConverter {
    static public List<Answer> AnswersDTOToList(AnswersDTO answersDTO){
        List<Answer> answers = new ArrayList<>();
        for (AnswerDTO answerDTO: answersDTO.answers()){
            answers.add(AnswerDTOToAnswer(answerDTO));
        }
        return answers;
    }

    static public Answer AnswerDTOToAnswer(AnswerDTO answerDTO){
        return new Answer(answerDTO.questionId(), answerDTO.answer());
    }

    static public AnswerReportsDTO AnswerReportListToAnswerReportsDTO(List<AnswerReport> answerReports){
        List<AnswerReportDTO> answerReportDTOs = new ArrayList<>();
        for (AnswerReport answerReport: answerReports){
            answerReportDTOs.add(AnswerReportToAnswerReportDTO(answerReport));
        }
        return new AnswerReportsDTO(answerReportDTOs);
    }

    static public AnswerReportDTO AnswerReportToAnswerReportDTO(AnswerReport answerReport){
        return new AnswerReportDTO(answerReport.questionId(), answerReport.correct());
    }
}
