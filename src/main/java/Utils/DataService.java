package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

public class DataService {


    private static Connection con;
     static Properties properties;

   public DataService(){
       try{
           FileInputStream read = new FileInputStream("properties/config.properties");
           properties = new Properties();
           properties.load(read);
           }catch (IOException e) {
           e.printStackTrace();
          }
   }

    /**
     * Load driver and connect to the database
     */
    public static Connection loadAndConnectDatabase() throws ClassNotFoundException, SQLException {
   //load driver to establish database connection
//        Class.forName("com.mysql.jdbc.driver");
// Create the connection object
//         con= DriverManager.getConnection(
//                "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6583438","sql6583438","nTfaWqEPFS");
         final String driver = properties.getProperty("driver");
          System.out.println(driver);
         final String HOST = properties.getProperty("host");
         final String DB_NAME = properties.getProperty("dbname");
         final String USER = properties.getProperty("user");
         final String PASSWORD = properties.getProperty("password");
         final String PORT = properties.getProperty("port");


        //load driver to establish database connection
        Class.forName(driver);
        // Create the connection object and connect to the DB
        con = DriverManager
                .getConnection(
                        "jdbc:postgresql://"+HOST+":"+PORT+"/"+DB_NAME+"",
                        USER,
                        PASSWORD
                );
        System.out.println("connect to the database successfully");
         return con;
    }

    /**
     * get a result of query
     */
    public static ResultSet getResultSet(String query) throws SQLException, ClassNotFoundException {
        Connection con = loadAndConnectDatabase();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        rs = st.executeQuery();
        return rs;
    }
}
