package Main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Imrana
 */
public class Connexion {
    
    Connection cons;
    
    public Connection mysql() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\n\n\t\t Pilote charger");
        } catch (ClassNotFoundException err) {
            JOptionPane.showMessageDialog(null," "+err.getMessage() , "Message d'erreur ", JOptionPane.ERROR_MESSAGE);
        }
        
        final String name = "jdbc:mysql://localhost:3306/hotel?serverTimezone=Africa/Niamey";
        final String user = "root";
        final String password = "";
        
        try {
            cons = DriverManager.getConnection(name, user, password);
            System.out.println("\n\t\t Connection a la base des donnees");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null," "+err.getMessage() , "Message d'erreur ", JOptionPane.ERROR_MESSAGE);
        }
       
        return cons;
    }
    
}
