/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercices;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public abstract class Exercice implements ExerciceActions{
    private static int idExercice = 0;
    private String name;
    private String objectif;
    private int note;
    protected List<Question> questions;  
  
    Scanner sc;

    public Exercice() {
        idExercice++;
        sc = new Scanner(System.in);
        questions = new ArrayList<>();
        note=0;
    }

    public Exercice(String name, String objectif) {
        this();  
        idExercice++;
        sc = new Scanner(System.in);
        questions = new ArrayList<>();
        this.name = name;
        this.objectif = objectif;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
     public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    
    // Add a question to the exercise
    public void addQuestion(Question question) {
        questions.add(question);
    }
    
    // Update question based on index
    
    public void updateQuestion(int index, Question newQuestion) {
        if (index >= 0 && index < questions.size()) {
            questions.set(index, newQuestion); 
            System.out.println("Question updated successfully!");
        } else {
            System.out.println("Invalid index. Cannot update question!");
        }
    }

    // Delete a question based on its index
    @Override
    public void deleteQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            questions.remove(index);  
            System.out.println("Question deleted successfully!");
        } else {
            System.out.println("Invalid index. Cannot delete question!");
        }
    }
    @Override
    // Display questions using Streams and Lambdas
    public void displayQuestions() {
        System.out.println("Questions for this exercise:");
        questions.stream()
                 .forEach(q -> System.out.println(q.toString()));
    }

    
    public void saisirExercice() {
        System.out.println("Enter exercise Name:");
        this.name = sc.nextLine();
         System.out.print("Objective: ");
        this.objectif = sc.nextLine();
    }
    
    public boolean checkAnswer(Question question, String userAnswer) {
        // For fill-in-the-blank or text-based responses
        if(question.getCorrectResponse().getResponseText().equalsIgnoreCase(userAnswer))
        {
            this.setNote(this.getNote()+1);
        }
        return question.getCorrectResponse().getResponseText().equalsIgnoreCase(userAnswer);
    }

   @Override
    public String toString() {
        return "Exercise Name: " + name + ", Objective: " + objectif;
    }

   
    
    @Override
    public abstract void startExercice();
      
}
