package day2;

import utility.DB_Utility;

import java.sql.*;

public class GettingMoreInfoAboutResultObject {

    public static void main(String[] args) throws SQLException {

        // we want to create a statement object that generate
        // ResultSet that can move forward and backward anytime
        String connectionStr = "jdbc:oracle:thin:@54.162.198.60:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        // this way of creating statement will give you ability to generate
        // ResultSet that can move forward and backward anytime
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs   =   stmt.executeQuery("SELECT * FROM EMPLOYEES") ;

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        System.out.println("column Count = " + colCount);

        System.out.println("First column name is: "+ rsmd.getColumnLabel(1));
        System.out.println("Second column name is: "+ rsmd.getColumnLabel(2));

        for (int colNum = 1; colNum<= colCount; colNum++){
            System.out.println("Column name: " + rsmd.getColumnLabel(colNum));
        }

        //clean up the connection, statement and resultant object after usage:
        DB_Utility.destroy();







    }
}
