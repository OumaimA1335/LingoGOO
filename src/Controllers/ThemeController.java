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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class ThemeController implements Initializable{
     
    @FXML
    ImageView image1;
    @FXML
    Text text1;
    ConnexionBD bd;
    Connection conBD;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        try {
            bd = new ConnexionBD();
            conBD = bd.getConnexion();
            PreparedStatement stmt = conBD.prepareStatement("select * from theme order by id desc");
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                  text1.setText(rs.getString("nom"));
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ThemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
}
    @FXML
    void selectTheme(MouseEvent event) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("../Views/choose lesson.fxml"));
        Scene scene = new Scene(root, 780, 600);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}