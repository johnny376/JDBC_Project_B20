package day2;

import java.sql.*;

public class Review {

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

        ResultSet rs   =   stmt.executeQuery("SELECT * FROM JOBS") ;

        rs.next();
        System.out.println("First column value in Jobs: " + rs.getString(1));
        System.out.println("Second column value in Jobs: " + rs.getString(2));

        rs.absolute(7);
        System.out.println("First column value in Jobs in row 7: " + rs.getString(1));
        System.out.println("Second column value in Jobs in row 7: " + rs.getString(2));

        rs.last();
        System.out.println("First column value in Jobs in last row : " + rs.getString(1));
        System.out.println("Second column value in Jobs in last row: " + rs.getString(2));

        rs.previous();
        System.out.println("First column value in Jobs in 2nd row from last row : " + rs.getString(1));
        System.out.println("Second column value in Jobs in 2nd row from last row: " + rs.getString(2));

        System.out.println("-----loop from top to bottom print JOB_ID-----");

        rs.beforeFirst();

        while(rs.next()){
            System.out.println("Loop First column : " + rs.getString("JOB_ID"));
        }

        System.out.println("-----loop from last row till first row get MIn_SALARY column as number-----");

        rs.afterLast();

        while(rs.previous()){
            System.out.println("MIN SALARY COLUMN AS NUMBER: $" + rs.getDouble("MIN_SALARY"));
        }

        //clean up the connection, statement and resultant object after usage:
        rs.close();
        stmt.close();
        conn.close();





    }
}
