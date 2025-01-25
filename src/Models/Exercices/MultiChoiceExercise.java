/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercices;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marwa
 */
public class MultiChoiceExercise extends Exercice {

    private List<String> correctAnswer;

    public MultiChoiceExercise() {
        super();
    }
    public MultiChoiceExercise(String name, String objectif) {
        super(name, objectif);
    }

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(List<String> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void addQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adding a new Multi-choice Exercice");
        super.saisirExercice();

        //add question
        System.out.println("How many question do you want to add ?");
        int numQuestion = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numQuestion; i++) {
            // Step 1: Get question text
            System.out.println("Enter Question" + (i + 1) + " : ");
            String questionText = sc.nextLine();
            // Step 2: Get correct response text
            System.out.print("Enter the correct response: ");
            String correctResponseText = sc.nextLine();
            Response correctResponse = new Response(correctResponseText);

            // Step 3: Create a Question object
            Question question = new Question(questionText, correctResponse);

            System.out.println("How many possible response for this question ?(Minimum 2 )");
            int numResponses = sc.nextInt();
            sc.nextLine();
            // Step 4: Collect possible responses (at least 2 options)
            while (numResponses < 2) {
                System.out.print("Please enter at least 2 responses: ");
                numResponses = sc.nextInt();
                sc.nextLine();
            }
            // a quoi sert cette boucle

            // Step 5: Add possible responses to the question
            question.addResponse(correctResponse); // Add the correct response first
             
            for (int j = 1; j < numResponses; j++) {
                System.out.print("Enter possible response " + (j + 1) + ": ");
                String responseText = sc.nextLine();
                Response response = new Response(responseText);
                question.addResponse(response);
            }

            // Step 6: Add the question to the exercise
            super.addQuestion(question);
        }
    }

    @Override
    public void startExercice() {
        System.out.println("Starting Multi-Choice Exercise: " + getName());
        
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println(question.getQuestionText());

            List<Response> responses = question.getPossibleResponses();
            for (int j = 0; j < responses.size(); j++) {
                System.out.println((j + 1) + ". " + responses.get(j).getResponseText());
            }

            // Get the user's answer
            System.out.print("Your answer (number): ");
            int answerIndex = sc.nextInt();

            // Validate and check the answer
            if (answerIndex >= 0 && answerIndex < responses.size()) {
                Response chosenResponse = responses.get(answerIndex-1);
                if (checkAnswer(question, chosenResponse.toString())) {
                   
                    System.out.println("Correct answer!");
                } else {
                    System.out.println("Incorrect answer. The correct answer is: " +
                        question.getCorrectResponse().getResponseText());
                }
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    @Override
    public void updateQuestion(int index, Question newQuestion) {
        super.updateQuestion(index, newQuestion);
    }

    @Override
    public void deleteQuestion(int index) {
        super.deleteQuestion(index);
    }

    @Override
    public String toString() {
        return super.toString() + " (Type: Fill-in-the-Blanks)";    
    }

  
}
