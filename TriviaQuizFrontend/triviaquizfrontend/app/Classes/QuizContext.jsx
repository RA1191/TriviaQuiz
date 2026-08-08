"use client";

import { createContext, useContext, useState } from "react";

const QuizContext = createContext(null);

export function QuizProvider({ children }) {
    const [questions, setQuestions] = useState([]);
    const [selectedAnswers, setSelectedAnswers] = useState([]);
    const [answerReports, setAnswerReports] = useState([]);

    return (
        <QuizContext.Provider
            value={{
                questions,
                setQuestions,
                selectedAnswers,
                setSelectedAnswers,
                answerReports,
                setAnswerReports,
            }}
        >
            {children}
        </QuizContext.Provider>
    );
}

export function useQuiz() {
    return useContext(QuizContext);
}