"use client";

import AnswerList from "../Classes/AnswerList";
import AnswerAPI from "../api/AnswerAPI";
import {useEffect} from "react";
import {useQuiz} from "../Classes/QuizContext";

export default function Page(){
    const {
        selectedAnswers,
        setAnswerReports,
    } = useQuiz();

    const checkAnswer = async () =>{
        AnswerAPI.checkAnswers(selectedAnswers)
            .then(data => setAnswerReports(data.answerReportDTOs))
    }

    useEffect(() => {
        checkAnswer();
    }, []);

    return(
        <div>
            <AnswerList/>
        </div>
    )
}