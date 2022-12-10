package Utils;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;

public class DataService {

    private static Connection con;

    public static Connection loadAndConnectDatabase() throws ClassNotFoundException, SQLException {
        //load driver to establish database connection.
        Class.forName("com.mysql.jdbc.driver");

        // Create the connection object
         con= DriverManager.getConnection(
                "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6583438","sql6583438","nTfaWqEPFS");

        System.out.println("connect to the database successfully");
         return con;
    }
}
