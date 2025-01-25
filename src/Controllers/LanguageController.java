/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class LanguageController implements Initializable {

    @FXML
    ListView<String> listeLangue;
    @FXML
    ListView<String> listeLangueLearn;
    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> langues = FXCollections.observableArrayList();
        listeLangue.setFixedCellSize(30); // Set the height of each cell
        listeLangue.setPrefHeight(30);
        listeLangueLearn.setFixedCellSize(30); // Set the height of each cell
        listeLangueLearn.setPrefHeight(30);
        try {
            bd = new ConnexionBD();
            conBD = bd.getConnexion();
            PreparedStatement stmt = conBD.prepareStatement("select * from langue");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                langues.add(rs.getString("langue"));
            }
            listeLangue.setItems(langues);

            listeLangueLearn.setItems(langues);

        } catch (SQLException ex) {
            Logger.getLogger(LanguageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void LanguageChoosen(ActionEvent event) throws SQLException, IOException {
        String Langue1 = listeLangue.getSelectionModel().getSelectedItem();
        String Langue2 = listeLangueLearn.getSelectionModel().getSelectedItem();
        if (Langue1 != null && Langue2 != null) {
            PreparedStatement stmt = conBD.prepareStatement("INSERT INTO languechoosen (languenative, langueselected) VALUES (?, ?)");
            stmt.setString(1, Langue1);
            stmt.setString(2, Langue2);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Insertion successful!");
                Parent root = FXMLLoader.load(getClass().getResource("../Views/choose topic.fxml"));
                Scene scene = new Scene(root, 590, 600);
                Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                System.out.println("No rows inserted.");
            }
        } else {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must select a native language and language you want to learn");
            error.showAndWait();
        }

    }

}
