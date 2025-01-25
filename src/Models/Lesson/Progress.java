/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Lesson;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Progress {

    private int idProg;
    private String nomlesson;
    private Date dateOfStart;
    private String isCompleted;
    private Double noteExercice;

    public Progress(int idProg, String nomlesson, Date dateOfStart, String isCompleted, Double noteExercice) {
        this.idProg = idProg;
        this.nomlesson = nomlesson;
        this.dateOfStart = dateOfStart;
        this.isCompleted = isCompleted;
        this.noteExercice = noteExercice;
    }

    public int getIdProg() {
        return idProg;
    }

    public void setIdProg(int idProg) {
        this.idProg = idProg;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Double getNoteExercice() {
        return noteExercice;
    }

    public void setNoteExercice(Double noteExercice) {
        this.noteExercice = noteExercice;
    }

    public String getNomlesson() {
        return nomlesson;
    }

    public void setNomlesson(String nomlesson) {
        this.nomlesson = nomlesson;
    }
    


}
