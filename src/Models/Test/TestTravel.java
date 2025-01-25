/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Test;

/**
 *
 * @author marwa
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTravel {
    private final List<TestQuestion> questions;

    public TestTravel(List<TestQuestion> questions) {
        this.questions = questions;
    }


    public List<String> startTest() {
        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new ArrayList<>();

        for (TestQuestion question : questions) {
            System.out.println(question.question());
            for (int i = 0; i < question.options().length; i++) {
                System.out.println((i + 1) + ". " + question.options()[i]);
            }

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim(); 
            userAnswers.add(userAnswer);
        }

        return userAnswers; // Return collected answers
    }

   /* public TestResult evaluate(List<String> userAnswers) {
        int correctAnswers = 0;
        List<TestQuestion> failedQuestions = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            TestQuestion question = questions.get(i);
            String userAnswer = userAnswers.get(i);

            System.out.println("User Answer: " + userAnswer);
            System.out.println("Correct Answer: " + question.correctAnswer());

            if (question.correctAnswer().equalsIgnoreCase(userAnswer)) {
                correctAnswers++;
            } else {
                failedQuestions.add(question); // Store the failed questions
            }
        }

        if (correctAnswers >= (questions.size() / 2)) {
            return new Pass("Test Passed!", "Congratulations! You passed the test.");
        } else {
            return new Fail("Test Failed!", "You failed the test. Please try again.");
        }
    }*/
}