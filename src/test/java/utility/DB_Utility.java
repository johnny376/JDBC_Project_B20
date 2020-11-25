package utility;

import java.sql.*;

public class DB_Utility {

    static Connection conn;// make it static field so we can reuse in every methods we write
    static ResultSet rs;
    static Statement stmt;


    public static void createConnection(){

        // we want to create a statement object that generate
        // ResultSet that can move forward and backward anytime
        String connectionStr = "jdbc:oracle:thin:@54.162.198.60:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        try {
            conn = DriverManager.getConnection(connectionStr, username, password);
            Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
            System.out.println("CONNECTION IS SUCCESSFUL!");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!!!"+e.getMessage());
        }
    }

    public static ResultSet runQuery(String query){
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stmt.executeQuery(query);

        } catch (SQLException e) {
            System.out.println("Error while getting resultSet "+e.getMessage());
        }
        return rs;
    }

    public static void destroy() throws SQLException {
        rs.close();
        stmt.close();
        conn.close();

    }

}
