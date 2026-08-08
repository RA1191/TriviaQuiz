"use client";

import Link from "next/link";
import {useQuiz} from "./QuizContext";

export default function QuestionList() {
    const {
        questions,
        selectedAnswers,
        setSelectedAnswers,
    } = useQuiz();

    const changeAnswer = (questionId, answer) => {
        setSelectedAnswers((prev) => [
            ...prev.filter((item) => item.questionId !== questionId),
        {questionId, answer}
        ]);
    };

    return (
        <div>
            {questions.map((question) => {
                const selectedAnswer = selectedAnswers.find(
                    (item) => item.questionId === question.questionId
                )?.answer;
                return (
                <div key={question.questionId}>
                    <h3>{question.question}</h3>
                    {question.answers.map((answer) => (
                        <label key={answer} style={{ display: "block" }}>
                            <input
                                type="radio"
                                name={question.questionId}
                                value={answer}
                                checked={selectedAnswer === answer}
                                onChange={() =>
                                    changeAnswer(
                                        question.questionId,
                                        answer
                                    )
                                }
                            />
                            {answer}
                        </label>
                    ))}
                </div>
                )
            })}
            <Link href="/answers">
                submit answers
            </Link>
        </div>
    );
}
