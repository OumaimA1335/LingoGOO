/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson;

import masterlanguagefx.MyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author ASUS
 */
public class GrammerLesson extends Lesson {

    private HashMap<Integer, StringBuffer> grammerRules;
    Stream<StringBuffer> StreamGramma;
    Scanner sc;

    public GrammerLesson() {
        super();
        grammerRules = new HashMap<Integer, StringBuffer>();
        this.StreamGramma = grammerRules.values().stream();
        sc = new Scanner(System.in);
    }

    public GrammerLesson(String title, String description) {
        super(title, description);
        grammerRules = new HashMap<Integer, StringBuffer>();
        this.StreamGramma = grammerRules.values().stream();
        sc = new Scanner(System.in);
    }

    @Override
    public void startLesson() {
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
            grammerRules.put(Integer.SIZE, new StringBuffer(sc.nextLine()));
            System.out.println("Voulez vous ajouter de nouveau");
            resp = sc.next();
        }

    }

    @Override
    public void update(int index) throws MyException {
        if (index > grammerRules.size()) {
            throw new MyException("ce élément n'existe pas");
        } else {
            System.out.println("Saisir le nouvelle mot modifieé  :");
            grammerRules.replace(index, new StringBuffer(sc.nextLine()));
        }
    }

    @Override
    public void delete(int index) throws MyException {
        if (index > grammerRules.size()) {
            throw new MyException("ce élément n'existe pas");
        } else {
            System.out.println("Voulez vous supprimer ce élement :");
            String answer = sc.next();
            if (answer.equals("oui")) {
                grammerRules.remove(index);
            }
        }
    }

    /*public void afficher() {
        grammerRules.values().forEach(System.out::println);
    }*/
    @Override
    public String toString() {
        return super.toString() + "\n Regles de grammaire: " + grammerRules;
    }

}
