/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercices;

/**
 *
 * @author marwa
 */
public class Response {
    private String responseText;

    public Response(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseText() {
        return responseText;
    }

    public boolean equals(Response response) {
        return responseText.equals(response.responseText);
    }

    @Override
    public String toString() {
        return responseText;
    }
}