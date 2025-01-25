/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.language;

import Exercices.ExerciceManager;
import Exercices.MultiChoiceExercise;
import Exercices.TranslationExercise;

/**
 *
 * @author ASUS
 */
public class Language {

    public static void main(String[] args) {
/*
        LessonPlan l = new LessonPlan();
        l.ajouterLesson();
        l.afficher();

        System.out.println("******************");
        System.out.println("Ajout un mot à une lesson!");
        try {
            l.remplissageTab(1);
        } catch (MyException e) {
            System.out.println(e);
        }
        l.afficher();

        System.out.println("******************");
        System.out.println("Modification!");
        try {
            l.modifier(1);
        } catch (MyException e) {
            System.out.println(e);
        }
        System.out.println("******************");
        System.out.println("Affichage!");
        l.afficher();

        System.out.println("******************");
        System.out.println("Suppression!");
        try {
            l.supprimer(1);
        } catch (MyException e) {
            System.out.println(e);
        }
        System.out.println("******************");
        System.out.println("Affichage!");
        l.afficher();
        System.out.println("******************");
        System.out.println("Affichage des lessons vocabulaire !");
        l.listeVocabLesson();
        System.out.println("******************");
        System.out.println("Affichage des lessons grammaire !");
        l.ListeGrammaLesson();
*/
        /* -------------------------Test Exercice class------------------------------------*/
        
        ExerciceManager exerciceManager = new ExerciceManager();
        
/* ------------------------------------test the Fill In The Blanks Class----------------------------------------------------------
        
        
       FillInTheBlanks fillEx1 = new FillInTheBlanks("English Grammar", "Test your grammar skills");
        System.out.println("Now adding questions for the English Grammar exercise...");
        fillEx1.addQuestion();
       // Add another exercice
        FillInTheBlanks fillEx2 = new FillInTheBlanks("Math Quiz", "Test your math skills");
        System.out.println("Now adding questions for the Math Quiz exercise...");
        fillEx2.addQuestion(); 

        // Add exercises to manager
        exerciceManager.addExercice(fillEx1);
        exerciceManager.addExercice(fillEx2);

        // Display all exercises
        exerciceManager.displayExercices();

        // Update the first exercise
        System.out.println("\nUpdating the first exercise...");
        FillInTheBlanks updatedEx = new FillInTheBlanks("Advanced English Grammar", "Improve your grammar skills");
        updatedEx.addQuestion();  // Add questions to the updated exercise interactively
        exerciceManager.updateExercice(0, updatedEx);
        // Display all exercises after update
        exerciceManager.displayExercices();

        // Delete the second exercise
        System.out.println("\nDeleting the second exercise...");
        exerciceManager.deleteExercice(1);

        // Display all exercises after deletion
        exerciceManager.displayExercices();
      */  
/*------------------------------------------Test Multiple-choice Class---------------------------------------------------------*/
       // MultiChoiceExercise multiChoiceExercise = new MultiChoiceExercise("Geography Quiz", "Test your geography knowledge!");

        //multiChoiceExercise.addQuestion();
        
        //multiChoiceExercise.startExercice();

 /*------------------------------------------Test Translation Exercice class --------------------------------------------------*/
 
        TranslationExercise transEx = new TranslationExercise("Translation from native language to the learning language or the opposite", "Test your vocab");

        transEx.addQuestion();
        
        transEx.startExercice();

    }
}
