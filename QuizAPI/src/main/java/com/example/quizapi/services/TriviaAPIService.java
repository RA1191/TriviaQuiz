package com.example.quizapi.services;

import com.example.quizapi.classes.GetQuestionsSet;
import com.example.quizapi.classes.Question;
import com.example.quizapi.classes.QuestionSetList;
import com.example.quizapi.converters.QuestionConverter;
import com.example.quizapi.dtos.questionsdtos.TriviaQuestionsDTO;
import com.example.quizapi.interfaces.ITriviaAPIService;
import com.google.gson.Gson;
import  com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TriviaAPIService implements ITriviaAPIService {


    @Override
    public QuestionSetList GetQuestions() throws Exception {
        Gson gson = new Gson();
        String uri = TriviaURIBuilder(new GetQuestionsSet(10, null, null, null, null));

        HttpResponse<String> response = httpRequest(uri);

        if(response.statusCode() == 200){
            Type type = new TypeToken<TriviaQuestionsDTO>() {}.getType();
            TriviaQuestionsDTO questionsDTO = gson.fromJson(response.body(), type);
            if(questionsDTO.response_code() == 0){
                List<Question> questions = QuestionConverter.TriviaQuestionsDTOToList(questionsDTO);
                return new QuestionSetList(questions.size(), questions);
            }
        }
        return new QuestionSetList(0, null);
    }

    private HttpResponse<String> httpRequest(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private String TriviaURIBuilder(GetQuestionsSet getQuestionsSet){
        String triviaURI = "https://opentdb.com/api.php";
        String requestURI = triviaURI + "?amount=" + getQuestionsSet.getAmount();
        if(getQuestionsSet.getCategory() != null && !getQuestionsSet.getCategory().equals("Any Category")){
            requestURI += "&category=" + getQuestionsSet.getCategory();
        }
        if(getQuestionsSet.getDifficulty() != null &&!getQuestionsSet.getDifficulty().equals("Any Difficulty")){
            requestURI += "&difficulty=" + getQuestionsSet.getDifficulty();
        }
        if(getQuestionsSet.getCategory() != null &&!getQuestionsSet.getType().equals("Any Type")){
            requestURI += "&type=" + getQuestionsSet.getType();
        }
        if(getQuestionsSet.getSessionId() != null){
            requestURI += "&token=" + getQuestionsSet.getSessionId();
        }
        return requestURI;
    }
}
