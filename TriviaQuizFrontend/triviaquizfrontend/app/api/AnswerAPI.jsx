import axios from 'axios';

const BACKEND_URL = "http://localhost:8080/checkanswers";

const AnswerAPI = {
    checkAnswers: (selectedAnswers) => axios.post(BACKEND_URL, {answers: selectedAnswers})
    .then(response => response.data)
}

export default AnswerAPI;