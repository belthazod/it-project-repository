/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Belthazod Tello
 */

public class DatabaseConnector {
    private static DatabaseConnector database = new DatabaseConnector();
    private String host;
    private String uName;
    private String uPass;
    private Connection connection;
    

/**
 * A private DatabaseConnector following the singleton design pattern
 * 
 *
 */
    private DatabaseConnector() {
        host = "jdbc:mysql://localhost:3306/inventory";
        uName = "root";
        uPass = "";

        try{
            connection = DriverManager.getConnection(host,uName, uPass);

        }catch(SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Database Error","Database not set up.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
 /**
 * @return <code>DatabaseConnector</code> the one and only DatabaseConnector instance 
 * 
 */

    public static DatabaseConnector getInstance(){
        return database;
    }
    
    /**
 * A method that queries from the set database based on the SQL statement given
 * and returns the result of the query in the form of a <code>ResultSet</code>
 *
 * @param queryStatement  The SQL statement to execute.  
 * @return <code>rs</code> The ResultSet based from the SQL Statement given.
 * @exception SQLException The SQL statement has an error.              
 */

    public ResultSet query(String queryStatement) throws SQLException{
        ResultSet rs = null;
        PreparedStatement selectStatement = connection.prepareStatement(queryStatement);
        rs = selectStatement.executeQuery();
        return rs;
    }

/**
 * A method that queries from the set database based on the SQL statement and values to 
 * be passed as arguments in the <code>PreparedStatement</code> given
 * and returns the result of the query in the form of a <code>ResultSet</code>
 *
 * @param queryStatement  The SQL statement to execute.
 * @param values The given values mapped to the "?"s in the query Statement.
 * @return <code>rs</code> The ResultSet based from the SQL Statement given.
 * @exception SQLException The SQL statement has an error.              
 */
    public ResultSet query(String queryStatement, String[] values) throws SQLException{
        ResultSet rs = null;
        PreparedStatement selectStatement = connection.prepareStatement(queryStatement);
        for(int i = 0; i < values.length; i++){
            selectStatement.setString( i+1 , values[i]);
        }
        rs = selectStatement.executeQuery();
        return rs;
    }
    
/**
 * A method that queries from the set database based on the SQL statement and values to 
 * be passed as arguments in the <code>PreparedStatement</code> given
 * and returns the result of the query in the form of a <code>ResultSet</code>
 *
 * @param queryStatement  The SQL statement to execute.
 * @param value The given value mapped to the "?" in the query Statement.
 * @return <code>rs</code> The ResultSet based from the SQL Statement given.
 * @exception SQLException The SQL statement has an error.              
 */
    public ResultSet query(String queryStatement, String value) throws SQLException{
        ResultSet rs = null;
        PreparedStatement selectStatement = connection.prepareStatement(queryStatement);
        selectStatement.setString( 1 , value);
        rs = selectStatement.executeQuery();
        return rs;
    }

 /**
 * A method that deletes rows from the set database based on the SQL statement.
 * 
 *
 * @param umlStatement  The SQL delete statement to execute.
 * @param values The given values mapped to the "?"s in the query Statement.
 * @exception SQLException Throws this exception if the SQL statement has an error.
 */
    public void delete(String umlStatement, String[] values) throws SQLException{
        
        Connection con = DriverManager.getConnection(host,uName, uPass);
        PreparedStatement deleteStatement = con.prepareStatement(umlStatement);
        deleteStatement.executeUpdate();
    }
    
/**
 * A method that adds new elements to the set database based on the SQL statement
 * and values to be stored matching each attribute.
 * 
 *
 * @param umlStatement  The SQL UML statement to execute.
 * @param values The given values mapped to the "?"s in the UML Statement.
 * @exception SQLException Throws this exception if the SQL statement has an error.
 */
    public void insert(String umlStatement, String[] values) throws SQLException{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        PreparedStatement insertStatement = con.prepareStatement(umlStatement);
        
        for(int i = 0; i<values.length ; i++){
            insertStatement.setString(i+1, values[i]);
        }
        
        insertStatement.executeUpdate();
        
    }
    
    /**
 * A method that adds new elements to the set database based on the SQL statement
 * and values to be stored matching each attribute.
 * 
 *
 * @param umlStatement  The SQL UML statement to execute.
 * @param values The values to be stored in the database
 * @param args  The given values mapped to the "?"s in the query Statement.
 * @exception SQLException Throws this exception if the SQL statement has an error.
 */
    public void update(String umlStatement, String[] values, String[] args) throws SQLException{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        PreparedStatement insertStatement = con.prepareStatement(umlStatement);
        
        for(int i = 0; i<values.length ; i++){
            insertStatement.setString(i+1, values[i]);
        }
        
        insertStatement.executeUpdate();
        
    }
    
        /**
 * A method that adds new elements to the set database based on the SQL statement
 * and values to be stored matching each attribute.
 * 
 *
 * @param umlStatement  The SQL UML statement to execute.
 * @param values The values to be stored in the database
 * @param arg  The given values mapped to the "?"s in the query Statement.
 * @exception SQLException Throws this exception if the SQL statement has an error.
 */
    public void update(String umlStatement, String[] values, String arg) throws SQLException{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        PreparedStatement insertStatement = con.prepareStatement(umlStatement);
        int i = 0;
        
        for(; i<values.length ; i++){
            insertStatement.setString(i+1, values[i]);
        }
        
        insertStatement.setString(i+1, arg);
        insertStatement.executeUpdate();
        
    }
    
        /**
 * A method that adds new elements to the set database based on the SQL statement
 * and values to be stored matching each attribute.
 * 
 *
 * @param umlStatement  The SQL UML statement to execute.
 * @param values The values to be stored in the database
 * @exception SQLException Throws this exception if the SQL statement has an error.
 */
    public void update(String umlStatement, String[] values) throws SQLException{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        PreparedStatement insertStatement = con.prepareStatement(umlStatement);
        
        for(int i = 0; i<values.length ; i++){
            insertStatement.setString(i+1, values[i]);
        }
        
        insertStatement.executeUpdate();
        
    }
}
