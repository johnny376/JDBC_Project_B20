package day2;

import utility.DB_Utility;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs   =   DB_Utility.runQuery("SELECT * FROM JOBS") ;

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
        DB_Utility.destroy();





    }
}
