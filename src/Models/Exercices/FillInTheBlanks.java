/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercices;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marwa
 */
public class FillInTheBlanks extends Exercice {

    private List<String> correctAnswers;

    public FillInTheBlanks() {
        super();
        this.correctAnswers = new ArrayList<>();
    }

    public FillInTheBlanks(String name, String objectif) {
        super(name, objectif);
        this.correctAnswers = new ArrayList<>();
    }

    // Check if the provided answer is correct 
    public void checkAnswer(int questionIndex, String answer) {
        String correctAnswer = correctAnswers.get(questionIndex - 1);
        if (correctAnswer.equalsIgnoreCase(answer)) {
            super.setNote(super.getNote() + 1);

            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer. The correct answer is: " + correctAnswer);
        }
    }

    @Override
    public void startExercice() {
        System.out.println("Starting Fill-in-the-Blanks exercise: " + getName());
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println(question.getQuestionText());
            System.out.print("Your answer: ");
            String answer = sc.nextLine();
            checkAnswer(i, answer);
        }
    }

    @Override
    public void addQuestion() {
        System.out.println("Adding a new Fill-in-the-Blanks exercise.");
        saisirExercice();
        System.out.println("How many questions would you like to add? ");
        int numQuestions = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numQuestions; i++) {
            System.out.println("*** Enter question " + (i + 1) + ": ***");
            String questionText = sc.nextLine();
            System.out.println("Enter the correct response for this question: ");
            String correctResponseText = sc.nextLine();
            Response correctResponse = new Response(correctResponseText);
            Question question = new Question(questionText, correctResponse);

            // Prompt for multiple responses minimum 3 responses and max 4 responses
            System.out.println("How many possible responses for this question? (3-4): ");
            int numResponses = Integer.parseInt(sc.nextLine());
            while (numResponses < 3 || numResponses > 4) {
                System.out.println("Please enter a valid number of responses (3-4): ");
                numResponses = sc.nextInt();
            }

            // Add the correct response first
            question.addResponse(correctResponse);

            for (int j = 1; j < numResponses; j++) {
                System.out.println("Enter possible response " + j + ": ");
                String responseText = sc.nextLine();
                Response response = new Response(responseText);
                question.addResponse(response);
            }
            addQuestion(question);
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
