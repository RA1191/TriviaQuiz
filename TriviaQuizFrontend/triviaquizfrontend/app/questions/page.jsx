"use client";

import QuestionList from "../Classes/QuestionList";
import React, {useEffect} from "react";
import QuestionAPI from "../api/QuestionAPI";
import {useQuiz} from "../Classes/QuizContext";

export default function Page(){
    const {
        setQuestions,
    } = useQuiz();

    const getQuestions = async () =>{
        QuestionAPI.getQuestions()
            .then(data => setQuestions(data.questions));
    }

    useEffect(() => {
        getQuestions();
    }, [])

    return(
        <div>
            <QuestionList/>
        </div>
    )
}