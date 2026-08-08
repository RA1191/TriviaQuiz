import axios from 'axios';

const BACKEND_URL = "http://localhost:8080/questions";

const QuestionAPI = {
    getQuestions: () => axios.get(BACKEND_URL)
    .then(response => response.data)
}

export default QuestionAPI;