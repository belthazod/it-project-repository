/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

//import static VIEW.CustomerUI.contactNumberEditInput;
import VIEW.Login;
import UTIL.DatabaseConnector;
import VIEW.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author AMD
 */
public class LogInController {
           private final DatabaseConnector dbConnector;
           PreparedStatement selectStatement = null;
           public LogInController(){
               dbConnector= DatabaseConnector.getInstance();
           }
           public void LogIn(JTextField userName, JTextField password){
        try{
            
        
        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
        
       Connection con = DriverManager.getConnection(host,uName, uPass);
        // new DatabaseConnector.startConnection();
        
        String selectString = "SELECT username, password, name FROM users";
        selectStatement = con.prepareStatement(selectString);
        ResultSet rs = selectStatement.executeQuery();
        
        boolean userNotFound = true;
            while(rs.next()){
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String name = rs.getString(3);
                    System.out.println(name);
                if(user.equals(userName.getText()) && pass.equals(password)){
                    userNotFound = false;
                    try{
                    
                    Main.setUser(name);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    userNotFound = true;
                }
                
            }
            
            if(userNotFound){
                Main main = new Main();
                Login login = new Login();
                main.setVisible(true);
                login.setVisible(false);
            }else{
                
            }
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
           }
}
