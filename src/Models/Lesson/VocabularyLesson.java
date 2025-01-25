/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson;

import masterlanguagefx.MyException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author ASUS
 */
public class VocabularyLesson extends Lesson {

    private ArrayList<String> vocabWords;
    Stream<String> StreamVocab;
    Scanner sc = new Scanner(System.in);

    ;
    public VocabularyLesson() {
        super();
        vocabWords = new ArrayList<String>();
        this.StreamVocab = vocabWords.stream();

    }

    public VocabularyLesson(String title, String description) {
        super(title, description);
        vocabWords = new ArrayList<String>();
        this.StreamVocab = vocabWords.stream();

    }

    @Override
   public  void startLesson() {

        System.out.println("La lesson : " + super.getId() + " a commencé ");
        //on peut récupérer la date et l'heure de début les stoker dans le bd , si on va utiliser bd
    }

    @Override
    public void saisir() {
        super.saisir();
        System.out.println("Remplissage du tableau : ");
        this.ajouter();
        
    }

    @Override
    public void ajouter() {
        String resp = "oui";
        while (resp.equals("oui")) {
            System.out.println("Saisir la nouvelle mot :");
            vocabWords.add(sc.next());
            System.out.println("Voulez vous ajouter de nouveau");
            resp = sc.next();
        }

    }

    @Override
    public void update(int index) throws MyException {

        if (index > vocabWords.size()) {
            throw new MyException("ce élément n'existe pas");
        } else {
            System.out.println("Saisir le nouvelle mot modifieé  :");
            vocabWords.set(index, sc.next());
        }
    }

    @Override
    public void delete(int index) throws MyException {
        if (index > vocabWords.size()) {
            throw new MyException("ce élément n'existe pas");
        } else {
            System.out.println("Voulez vous supprimer ce élement :");
            String answer = sc.next();
            if (answer.equals("oui")) {
                vocabWords.remove(index);
            }
        }
    }

    /*public void afficher() {
        StreamVocab.forEach(System.out::println);
    }*/
    // returner un vocab à indice i en utilisant stream
    public Optional<String> find(int index) {
        return StreamVocab.skip(index - 1).findFirst();
    }

    @Override
    public String toString() {
        return super.toString() + "\nMots de vocabulaire: " + vocabWords;
    }

}
