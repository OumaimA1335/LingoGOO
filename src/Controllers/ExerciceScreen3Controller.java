/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ExerciceScreen3Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView correctImage;
    @FXML
    ImageView falseImage;
    @FXML
    private TextField response;
    @FXML
    Button verifyButton;
    @FXML
    private Text choice1;

    @FXML
    private Text choice2;

    @FXML
    private Text choice3;

    @FXML
    private Text choice4;
    @FXML
    private Text title;
    @FXML
    private Text question;
    int nbClick =0;
    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        correctImage.setVisible(false);
        falseImage.setVisible(false);
        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchExerciceData();
    }

    private void fetchExerciceData() {
        String query = "SELECT title,question,choices FROM multichoice WHERE ID = 1";

        try {

            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titledb = resultSet.getString("title");
                String questiondb = resultSet.getString("question");
                String choicesdb = resultSet.getString("choices");
                String[] choices = choicesdb.split(",");

                title.setText(titledb);
                question.setText(questiondb);
                choice1.setText(choices[0]);
                choice2.setText(choices[1]);
                choice3.setText(choices[2]);
                choice4.setText(choices[3]);
            } else {
                title.setText("No word found");
                question.setText("No word found");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch the title and the question: " + e.getMessage());
        }
    }

    @FXML
    void MultiChoices(ActionEvent event) {
       nbClick ++;
        if (response.getText().isEmpty()) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must choose an answer");
            error.showAndWait();
        } else {
            String query = "SELECT response FROM multichoice WHERE id = 1";
            try {
                PreparedStatement statement = conBD.prepareStatement(query);
                ResultSet resultset = statement.executeQuery();
                if (resultset.next()) {
                    String res = resultset.getNString("response");
                    if (response.getText().equals(res)) {
                        correctImage.setVisible(true);
                        falseImage.setVisible(false);
                         if (nbClick == 1) {
                            String query2 = "UPDATE progress SET noteexercice = ? WHERE lesssonCompleted = ?";
                            PreparedStatement statement2 = conBD.prepareStatement(query2);
                            statement2.setInt(1, 2);
                            statement2.setInt(2, 1);
                            statement2.executeUpdate();

                        }
                       
                        //move to next page

                        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel4.fxml"));
                        Scene scene = new Scene(root);
                        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    } else {
                        if (nbClick == 1) {
                            String query2 = "UPDATE progress SET noteexercice = ? WHERE lesssonCompleted = ? AND typeLesson = ?";
                            PreparedStatement statement2 = conBD.prepareStatement(query2);
                            statement2.setInt(1, 2);
                            statement2.setInt(2, 1);
                            statement2.setString(3,"Grammar Lesson");
                            statement2.executeUpdate();

                        }
                        falseImage.setVisible(true);
                        
                        
                    }
                } else {
                    response.setText("No word found");
                }

            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to verify the response: " + e.getMessage());

            }

        }
    }
     @FXML
    void Previous(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreen3Travel.fxml"));
                        Scene scene = new Scene(root);
                        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(scene);
                        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
