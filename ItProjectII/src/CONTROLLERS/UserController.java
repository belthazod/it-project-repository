/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.Account;
import UTIL.DatabaseConnector;
import UTIL.InputValidator;
import UTIL.TableManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class UserController {
    private DatabaseConnector dbConnector;
    private TableManager userTableManager;
    private JTable userTable;
    private JTextField usernameInput;
    private JTextField nameInput;
    private JPasswordField passwordInput;
    private JDialog editAdminDialog;
    private JPasswordField oldAdminPasswordInput;
    private JPasswordField newAdminPasswordInput;
    private JPasswordField newAdminPasswordConfirmInput;
    private JPasswordField oldUserPasswordInput;
    private JPasswordField newUserPasswordInput;
    private JPasswordField newUserPasswordConfirmInput;
    private JLabel username;
    private JDialog editUserDialog;
    private static ArrayList<Account> accountList;
    
    public UserController(JPasswordField oldUserPasswordInput, 
            JPasswordField newUserPasswordInput, 
            JPasswordField newUserPasswordConfirmInput,
            JDialog editUserDialog, JLabel username){
        dbConnector = DatabaseConnector.getInstance();
        this.oldUserPasswordInput = oldUserPasswordInput;  
        this.newUserPasswordInput = newUserPasswordInput; 
        this.newUserPasswordConfirmInput = newUserPasswordConfirmInput;
        this.username = username;
        this.editUserDialog = editUserDialog;
    }
    /**
     * 
     * @param userTable - the <code>JTable</code> containing the list of users and their respective name
     * @param usernameInput - the <code>JTextField</code> containing the username of the new user to be added
     * @param nameInput - the <code>JTextField</code> containing the name of the new user to be added
     * @param passwordInput - the <code>JPasswordField</code> containing the password of the new user to be added
     * @param editAdminDialog - the <code>JDialog</code> that pops out whenever the admin would like to change his/her password
     * @param oldAdminPasswordInput - the <code>JPasswordField</code> containing the old password of the admin which will soon be changed
     * @param newAdminPasswordInput - the <code>JPasswordField</code> containing the new password of the admin to be used
     * @param newAdminPasswordConfirmInput - the <code>JPasswordField</code> containing and confirming the new password of the administrator
     */
    public UserController(JTable userTable, JTextField usernameInput,JTextField nameInput, JPasswordField passwordInput, JDialog editAdminDialog, JPasswordField oldAdminPasswordInput, JPasswordField newAdminPasswordInput, JPasswordField newAdminPasswordConfirmInput){
        dbConnector = DatabaseConnector.getInstance();
        this.userTable = userTable;
        this.usernameInput = usernameInput;
        this.nameInput = nameInput;
        this.passwordInput = passwordInput;
        this.editAdminDialog = editAdminDialog;
        this.oldAdminPasswordInput = oldAdminPasswordInput;
        this.newAdminPasswordInput = newAdminPasswordInput;
        this.newAdminPasswordConfirmInput = newAdminPasswordConfirmInput;
        userTableManager = new TableManager(userTable);
        accountList = new ArrayList<Account>();
        
    }
    
    public void addUser(){
        
        try{
        
        JTextField[] inputs = {usernameInput, nameInput, passwordInput};
        
        if(InputValidator.checkInput(usernameInput.getText(), "Username cannot be empty")
            & InputValidator.checkInput(nameInput.getText(), "Name cannot be empty")    
            & InputValidator.checkInput(new String(passwordInput.getPassword()), "Password cannot be empty")){
            
            dbConnector.insert("INSERT INTO users (username, name, password) "
                    + "VALUES(?,?,?)", 
                    new String[]{usernameInput.getText(), nameInput.getText(),
                        new String(passwordInput.getPassword())});
            JOptionPane.showMessageDialog(null, nameInput.getText() + " has been added to list of users.", "Success", JOptionPane.INFORMATION_MESSAGE);
            InputValidator.clearInput(inputs);
            updateUsersTable();
        }
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add User.","Database error",JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Queries from the database the list of users and displays their name and username on the User <code>JTable</code>
     */
    public void updateUsersTable(){
        try{ 
            userTableManager.importDBContents(dbConnector.query("SELECT username, name FROM users ORDER BY 2")); 
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update Users' table", "Database error.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void getUsersList(){
        try{
            ResultSet rs = dbConnector.query("SELECT username, name, password FROM users");
            while(rs.next()){
                String username = rs.getString(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                
                accountList.add(new Account(username, password, name));
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            
        }
    }
    
    /**
     * deletes the selected user in the User <code>JTable</code>
     */
    public void deleteSelectedUser(){
        String username = "";
        try{
            username = userTableManager.getIDFromTable(userTableManager.getSelectedRow());
            int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + username + " from the Users List","Warning!" ,JOptionPane.YES_NO_OPTION);
            
            if(result == 0){
                dbConnector.delete("DELETE FROM users WHERE username = ?", username);
                updateUsersTable();
                JOptionPane.showMessageDialog(null,  username + " deleted from user list.", "Success", JOptionPane.INFORMATION_MESSAGE);
                
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete " + username +" from the Users list.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void openEditAdminDialog(){
        editAdminDialog.setVisible(true);
    }
    
    public void changeAdminPassword(){
        String oldPassword = new String(oldAdminPasswordInput.getPassword());
        String newPassword = new String(newAdminPasswordInput.getPassword());
        String newPasswordConfirm = new String(newAdminPasswordConfirmInput.getPassword());
        if(InputValidator.checkInput(new String(oldAdminPasswordInput.getPassword()), "Old admin password cannot be empty.")
                & InputValidator.checkInput(new String(newAdminPasswordInput.getPassword()), "New admin password cannot be empty.")
                & InputValidator.checkInput(new String(newAdminPasswordConfirmInput.getPassword()), "Confirm admin password cannot be empty.")){
            if(newPassword.equals(newPasswordConfirm)){
                try{
                    ResultSet rs = dbConnector.query("SELECT password FROM users WHERE username = ' ' ");
                    rs.next();
                    System.out.println(rs.getString(1));
                    System.out.println(oldAdminPasswordInput);
                    if(rs.getString(1).equals(oldPassword)){
                        dbConnector.update("UPDATE users SET password = ? where username = ?;", new String[]{ newPassword }, " ");
                        JOptionPane.showMessageDialog(null, "Admin credentials updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect administrator password.", "Input error.", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(SQLException sqlE){
                    sqlE.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Input Error.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void closeEditDialog(){
        editAdminDialog.dispose();
    }
    
    public void changeUserPassword(){
        String oldPassword = new String(oldUserPasswordInput.getPassword());
        String newPassword = new String(newUserPasswordInput.getPassword());
        String newPasswordConfirm = new String(newUserPasswordConfirmInput.getPassword());
        if(InputValidator.checkInput(new String(oldUserPasswordInput.getPassword()), "Old user password cannot be empty.")
                & InputValidator.checkInput(new String(newUserPasswordInput.getPassword()), "New user password cannot be empty.")
                & InputValidator.checkInput(new String(newUserPasswordConfirmInput.getPassword()), "Confirm user password cannot be empty.")){
            if(newPassword.equals(newPasswordConfirm)){
                try{
                    ResultSet rs = dbConnector.query("SELECT password FROM users WHERE username = ? ", username.getText());
                    rs.next();
                    System.out.println(rs.getString(1));
                    System.out.println(oldPassword);
                    if(rs.getString(1).equals(oldPassword)){
                        dbConnector.update("UPDATE users SET password = ? where username = ?;", new String[]{ newPassword }, username.getText());
                        JOptionPane.showMessageDialog(null, "User credentials updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        editUserDialog.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect user password.", "Input error.", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(SQLException sqlE){
                    sqlE.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Input Error.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
