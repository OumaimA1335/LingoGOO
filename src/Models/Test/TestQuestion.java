/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Test;

/**
 *
 * @author marwa
 */
public record TestQuestion(String question, String correctAnswer, String[] options) {
    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equals(userAnswer);
    }
}
