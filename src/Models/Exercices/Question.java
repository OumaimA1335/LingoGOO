/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author marwa
 */
public class Question {
    private String questionText;
    private List<Response> possibleResponses;
    private Response correctResponse;

   public Question(String questionText, Response correctResponse) {
        this.questionText = questionText;
        this.correctResponse = correctResponse;
        this.possibleResponses = new ArrayList<>();
    }
    public String getQuestionText() {
        return questionText;
    }

    public List<Response> getPossibleResponses() {
        return possibleResponses;
    }

    public Response getCorrectResponse() {
        return correctResponse;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setPossibleResponses(List<Response> possibleResponses) {
        this.possibleResponses = possibleResponses;
    }

    public void setCorrectResponse(Response correctResponse) {
        this.correctResponse = correctResponse;
    }
    
     public void addResponse(Response response) {
        possibleResponses.add(response);
    }

    public boolean checkResponse(Response response) {
        return response.equals(correctResponse);
    }

    @Override
    public String toString() {
        return "Question: " + questionText + "\nPossible Responses: " +
            possibleResponses.stream()
                             .map(Response::toString)
                             .collect(Collectors.joining(", "));
    }
}