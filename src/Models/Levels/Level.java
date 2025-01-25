/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Levels;

import Lesson.GrammerLesson;
import Lesson.Lesson;
import Lesson.VocabularyLesson;
import masterlanguagefx.MyException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author ASUS
 */
public class Level implements StartLevel {

    private static int id;
    private String name;
    private final int minScore = 20;
    private HashMap<Integer, Lesson> LessonList;
    Scanner sc;
    Stream<Lesson> lessonStream;

    public Level(String name) {

        id++;
        this.name = name;
        LessonList = new HashMap<Integer, Lesson>();
        sc = new Scanner(System.in);

    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Lesson> getLessonList() {
        return LessonList;
    }

    public void setLessonList(HashMap<Integer, Lesson> LessonList) {
        this.LessonList = LessonList;
    }

    public int getMinScore() {
        return minScore;
    }

    @Override
    public void startLevel() {
        int i = 0;

        while (i < LessonList.size()) {
            LessonList.get(i).startLesson();
            for (int j = 0; j <= LessonList.get(i).getEXManager().getExercices().size(); j++) {
                LessonList.get(i).getEXManager().getExercices().get(j).startExercice();
            }
            i++;
        }

    }

    public void ajouterLesson() {
        Lesson l;
        int choix;
        String resp = "oui";
        while (resp.equals("oui")) {
            System.out.println("Choissez ce que vous voulez ajoutez \n 1 : une lesson vocabulaire || 2 : une lesson de grammer");
            choix = sc.nextInt();
            if (choix == 1) {
                l = new VocabularyLesson();
                l.saisir();
                LessonList.put(l.getId(), l);
            } else {
                l = new GrammerLesson();
                l.saisir();
                LessonList.put(l.getId(), l);
            }
            System.out.println("Voulez vous ajoutez une autre lesson");
            resp = sc.next();
        }
    }

    // remplissage le tableau de vocab ou grammaire d'une lesson
    public void remplissageTab(int index) throws MyException {
        if (index > LessonList.size()) {
            throw new MyException("ce élément n'existe pas");
        } else {
            LessonList.get(index).ajouter();
        }
    }

    public void afficher() {
        this.lessonStream = LessonList.values().stream();
        lessonStream.forEach(System.out::println);
    }

    //supprimer une lesson
    public void supprimer(int index) throws MyException {
        if (index > LessonList.size()) {
            throw new MyException("ce élément n'existe pas");
        } else {
            System.out.println("Voulez vous supprimer ce élement :");
            String answer = sc.next();
            if (answer.equals("oui")) {
                LessonList.remove(index);
            }
        }
    }

    //modifier une lesson
    public void modifier(int index) throws MyException {
        Lesson l;
        if (LessonList.size() < index) {
            throw new MyException("ce element n existe pas");
        } else {
            if (LessonList.get(index) instanceof VocabularyLesson) {
                l = new VocabularyLesson();
                l.saisir();
                LessonList.replace(index, l);
            } else {
                l = new GrammerLesson();
                l.saisir();
                LessonList.replace(index, l);
            }

        }

    }

    //retourner les lessons vovaulaire seulement
    public void listeVocabLesson() {
        this.lessonStream = LessonList.values().stream();
        lessonStream
                .filter(lesson -> lesson instanceof VocabularyLesson)
                .forEach(System.out::println);

    }

    //retourner le lessons grammaire seulement
    public void ListeGrammaLesson() {
        this.lessonStream = LessonList.values().stream();
        lessonStream
                .filter(lesson -> lesson instanceof GrammerLesson)
                .forEach(System.out::println);
    }

    public void nbLessonPerLevel() {
        System.out.println("Le nombre des lessons dans ce  niveau est " + LessonList.size());
    }

    @Override
    public String toString() {
        return "Level{" + "name=" + name + ", minScore=" + minScore + ", LessonList=" + LessonList + '}';
    }

}
