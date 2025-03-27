package com.mycompany.finallab.database;
import org.apache.derby.jdbc.ClientDriver;
import java.sql.*;


public class DAO {

       public static int register(UserDTO user) throws SQLException {
    int result = -1;
    
    
    // Register the new user
    try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register1", "root", "root");
         PreparedStatement statement = connection.prepareStatement("INSERT INTO usertable (email, password) VALUES (?, ?)")) {
        
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        result = statement.executeUpdate();

    return result;

    }
    }

    public static boolean login(UserDTO user)throws SQLException {
        boolean result = false;
        String sql = "SELECT * FROM usertable WHERE email = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register1","root", "root");
            
                
         PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());

            java.sql.ResultSet resultset = statement.executeQuery();
            if(resultset.next()){
                
                result =true;
                System.out.println("login succesfully");
            }
            else{
                System.out.println("login failed");
            }
          
        resultset.close();
        connection.close();
        } 
        return result;
    }
}
