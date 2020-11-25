package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Utility {

    public static void main(String[] args) {

        createConnection();


    }


    public static void createConnection(){

        // we want to create a statement object that generate
        // ResultSet that can move forward and backward anytime
        String connectionStr = "jdbc:oracle:thin:@54.162.198.60:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        try {
            Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
            System.out.println("CONNECTION IS SUCCESSFUL!");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!!!"+e.getMessage());
        }

    }



}
