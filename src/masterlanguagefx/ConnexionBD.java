/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package masterlanguagefx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */

public class ConnexionBD {

    private final String Host = "localhost";
    private final String port = "3306";
    private final String DB = "lingogo";
    private final String User = "root";
    private final String Password = "";

    public Connection getConnexion() {
        Connection connexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + Host + ":" + port + "/" + DB;
            connexion = DriverManager.getConnection(url, User, Password);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return connexion;
    }
}
