"use client";

import Link from "next/link";
import {useQuiz} from "./QuizContext";

export default function AnswerList() {
    const {
        questions,
        selectedAnswers,
        answerReports,
    } = useQuiz();

    const newQuiz = () => {
        setSelectedAnswers([]);
        setAnswerReports([]);
    };

    return (
        <div>
            {questions.map((question) => {
                const selectedAnswer = selectedAnswers.find(
                    item => item.questionId === question.questionId
                )?.answer;
                const report = answerReports.find(
                    item => item.questionId === question.questionId
                );
                return (
                    <div key={question.questionId}>
                        <h3>{question.question}</h3>
                        {report !== undefined && (
                            <p
                                style={{
                                    color: report.correct ? "green" : "red",
                                    fontWeight: "bold"
                                }}
                            >
                                {selectedAnswer}
                            </p>
                        )}
                    </div>
                );
            })}
            <Link href="/questions" onClick={newQuiz}>
                Get new Questions
            </Link>
        </div>
    );
}
