/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Exercices;

/**
 *
 * @author marwa
 */
public interface ExerciceActions {
    void startExercice();
    void addQuestion();
    void updateQuestion(int index, Question newQuestion);
    void deleteQuestion(int index);
    void displayQuestions();
   
}
