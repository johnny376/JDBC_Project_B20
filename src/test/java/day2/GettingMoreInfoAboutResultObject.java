package day2;

import utility.DB_Utility;

import java.sql.*;

public class GettingMoreInfoAboutResultObject {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs   =  DB_Utility.runQuery("SELECT * FROM EMPLOYEES") ;

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
