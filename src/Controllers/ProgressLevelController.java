/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.Lesson.Progress;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProgressLevelController implements Initializable {

    @FXML
    private TableColumn<Progress, String> lessonName;
    @FXML
    private TableColumn<Progress, String> completed;
    @FXML
    private TableColumn<Progress, Double> noteExercice;
    @FXML
    private TableColumn<Progress, Date> DateOfStart;
    @FXML
    private TableView<Progress> tableProg;
    ObservableList<Progress> list = FXCollections.observableArrayList();
    ConnexionBD bd;
    Connection conBD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConnexionBD bd = new ConnexionBD();
        Connection conBD = bd.getConnexion();
        PreparedStatement stmt;
        PreparedStatement stmtNomLesson;
        String nomLesson="";
        String iscompleted;
        Date dLesson;
        Double note;
        try {
            stmt = conBD.prepareStatement("SELECT * FROM progress");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idProg");
                String typeLesson = rs.getString("typeLesson");
                 dLesson = rs.getDate("DateOfStart");
                 note=rs.getDouble("noteexercice");
                if(rs.getInt("lesssonCompleted")!=0)
                {
                   iscompleted ="Yes";
                if (typeLesson.equals("Grammar Lesson")) {
                    stmtNomLesson = conBD.prepareStatement("select * from lessonsgrammar where id = ?");
                    stmtNomLesson.setInt(1, rs.getInt("lesssonCompleted"));
                    ResultSet rs2 = stmtNomLesson.executeQuery();
                    while (rs2.next()) {
                         nomLesson = rs2.getString("nom");
                    }

                } else {
                    stmtNomLesson = conBD.prepareStatement("select * from vocabularylesson where id = ?");
                    stmtNomLesson.setInt(1, rs.getInt("lesssonCompleted"));
                    ResultSet rs2 = stmtNomLesson.executeQuery();
                    while (rs2.next()) {
                         nomLesson = rs2.getString("nom");
                    }
                }
               // System.out.println(iscompleted);
                list.add(new Progress(id,nomLesson,dLesson,iscompleted,note));
                }
           
               lessonName.setCellValueFactory(new PropertyValueFactory<Progress,String>("nomlesson"));
               completed.setCellValueFactory(new PropertyValueFactory<Progress,String>("isCompleted"));
               noteExercice.setCellValueFactory(new PropertyValueFactory<Progress,Double>("noteExercice"));
               DateOfStart.setCellValueFactory(new PropertyValueFactory<Progress,Date>("dateOfStart"));
               
               tableProg.setItems(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressLevelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void ContinueLesson(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/choose lesson.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
