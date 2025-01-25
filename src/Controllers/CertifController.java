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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CertifController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Text score;
    @FXML
    private Button move;
    @FXML
    private ImageView image2;
    ConnexionBD bd;
    Connection conBD;
    double noteTest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bd = new ConnexionBD();
        conBD = bd.getConnexion();

        try {
            String getIdQuery = "SELECT MAX(idProg) AS last_id FROM testprogres";
            PreparedStatement getIdStatement = conBD.prepareStatement(getIdQuery);
            ResultSet rs = getIdStatement.executeQuery();
            if (rs.next()) {
                int lastId = rs.getInt("last_id");

                String query2 = "SELECT noteTest FROM testprogres  WHERE idProg = ?";
                PreparedStatement statement2 = conBD.prepareStatement(query2);
                statement2.setDouble(1, lastId);
                ResultSet rs2 = statement2.executeQuery();
                while (rs2.next()) {
                    score.setText("Totaly score : " + rs2.getDouble("noteTest"));
                    noteTest = rs2.getDouble("noteTest");
                    if (noteTest >= 40) {
                        image2.setVisible(false);
                        move.setText("Move to the next Level");

                    } else {
                        image.setVisible(false);
                        move.setText("Retake the test");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CertifController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void moveOn(ActionEvent event) throws IOException {
        if(noteTest>=40)
        {
                
                Parent root = FXMLLoader.load(getClass().getResource("../Views/choose topic.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
        }
        else
        {
                Parent root = FXMLLoader.load(getClass().getResource("../Views/TestTravel.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();  
        }
    }

}
