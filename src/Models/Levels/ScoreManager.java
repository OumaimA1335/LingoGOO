/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Levels;

import Exercices.FillInTheBlanks;
import Exercices.TranslationExercise;

/**
 *
 * @author ASUS
 */
public class ScoreManager {

    private int ScorePerLevel;

    public ScoreManager() {
        this.ScorePerLevel = 0;
    }
    
    public ScoreManager(int ScorePerLevel) {
        this.ScorePerLevel = ScorePerLevel;
    }

    public int getScorePerLevel() {
        return ScorePerLevel;
    }

    public void setScorePerLevel(int ScorePerLevel) {
        this.ScorePerLevel = ScorePerLevel;
    }

    public int calculScorePerLevel(Level l) {
        int score = 0;
        // je recupere tous les lessons de ce niveau 
        // je recupere tous les exercices d'une lesson
        // je recupere le note d'un exercice
        score = l.getLessonList().get(1).getEXManager().getExercices().get(0).getNote();
        for (int i = 1; i < l.getLessonList().size(); i++) {
            for (int j = 0; j < l.getLessonList().get(i).getEXManager().getExercices().size(); j++) {
                score += l.getLessonList().get(i).getEXManager().getExercices().get(j).getNote();
            }

        }
        this.setScorePerLevel(score);
        System.out.println("le score pour cette niveau est :" + ScorePerLevel);
        return ScorePerLevel;
    }

    public void calculScorePerLesson(Level l, int index) {
        int score = 0;
        for (int i = 0; i < l.getLessonList().get(index).getEXManager().getExercices().size(); i++) {

            score += l.getLessonList().get(index).getEXManager().getExercices().get(i).getNote();

        }
        System.out.println("le score pour la lesson :" + index + " est :" + score);
    }
     // kind of statics per lessons
    public void afficherNotesPerLesson(Level l, int index)
    {
      
         System.out.println("Cette lesson a  :" + l.getLessonList().get(index).getEXManager().getExercices().size() + " exercices ");
        for (int i = 1; i < l.getLessonList().get(index).getEXManager().getExercices().size(); i++) {

           if(l.getLessonList().get(index).getEXManager().getExercices().get(i) instanceof FillInTheBlanks)
           {
                System.out.println("la note pour l'exercice Fill in the blanks est " + l.getLessonList().get(index).getEXManager().getExercices().get(i).getNote());
           }else if(l.getLessonList().get(index).getEXManager().getExercices().get(i) instanceof TranslationExercise)
           {
               
              System.out.println("la note pour l'exercice Translation Exercise est " + l.getLessonList().get(index).getEXManager().getExercices().get(i).getNote());
           }else
           {
               System.out.println("la note pour l'exercice MultiChoice Exercise est " + l.getLessonList().get(index).getEXManager().getExercices().get(i).getNote());
           }

        }
    }
    public void moyenPerlesson(Level l ,int index)
    { int score =0; 
       for (int i = 0; i < l.getLessonList().get(index).getEXManager().getExercices().size(); i++) {
            
            score +=l.getLessonList().get(index).getEXManager().getExercices().get(i).getNote();
        }
      
        System.out.println("la moyenne des note pour cette lesson est : "+score/l.getLessonList().get(index).getEXManager().getExercices().size());
    }

}
