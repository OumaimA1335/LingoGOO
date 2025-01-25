/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Levels;

/**
 *
 * @author ASUS
 */
public class Certificat {

    private String nom;
    private String prenom;
    private String level;
    private int score;
    private boolean res;

    public Certificat(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public void assignCertificate(Level l) {
        int scoreLevel;
        ScoreManager scMg = new ScoreManager();
        scoreLevel = scMg.calculScorePerLevel(l);
        if (scoreLevel < l.getMinScore()) {
            this.setScore(scoreLevel);
            this.setRes(false);
        } else {
            this.setScore(scoreLevel);
            this.setRes(true);
            this.setLevel(l.getName());
        }

    }

    @Override
    public String toString() {
        return "Certificat{" + "nom=" + nom + ", prenom=" + prenom + ", level=" + level + ", score=" + score + ", res=" + res + '}';
    }

}
