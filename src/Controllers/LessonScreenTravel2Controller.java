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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author marwa
 */
public class LessonScreenTravel2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String id;
    Boolean played1 = false;
    Boolean played2 = false;
    Boolean played3 = false;
    int idLesson = 0;
    ConnexionBD bd;
    Connection conBD;
    @FXML
    private Text title;
    @FXML
    private Text description;
    @FXML
    private Button word1;
    @FXML
    private Button word2;
    @FXML
    private Button word3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchLesson();
    }

    private void fetchLesson() {
        String query = "SELECT * FROM vocabularylesson WHERE id= 2";
        int pos = 0;
        int pos2=0;

        try {

            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idLesson = resultSet.getInt("id");
                title.setText(resultSet.getString("nom"));
                description.setText(resultSet.getString("description"));
                pos = resultSet.getString("words").indexOf(',');
                word1.setText(resultSet.getString("words").substring(0, pos));
                pos2=resultSet.getString("words").substring(pos).indexOf(',');
                word2.setText(resultSet.getString("words").substring(pos + 1,pos2));
                word3.setText(resultSet.getString("words").substring(pos2 + 1));

            }

        } catch (Exception e) {
            //showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch lesson: " + e.getMessage());
        }
    }

    @FXML
    void playHotelSound(ActionEvent event) {
        played1=true;
        String pathAirport = getClass().getResource("../Sounds/hotel.mp3").toString();
        Media media = new Media(pathAirport);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @FXML
    void playMapSound(ActionEvent event) {
        played3 =true;
        String pathAirport = getClass().getResource("../Sounds/map.mp3").toString();
        Media media = new Media(pathAirport);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    @FXML
    void playTicketSound(ActionEvent event) {
        played2 = true;
        String pathAirport = getClass().getResource("../Sounds/ticket.mp3").toString();
        Media media = new Media(pathAirport);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    @FXML
    void Next(MouseEvent event) throws IOException, SQLException {
        if (played1 == true && played2 == true && played3 == true) {
            String query = "INSERT INTO progress (lesssonCompleted,typeLesson,DateOfStart) VALUES (?,?,?)";
            PreparedStatement statement = conBD.prepareStatement(query);
            statement.setInt(1, idLesson);
            statement.setString(2, "Vocabulary Lesson");
             statement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            statement.executeUpdate();
            Parent root = FXMLLoader.load(getClass().getResource("../Views/ExerciceScreen4.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }

    @FXML
    void Previous(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/ExerciceScreen1.fxml"));
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
