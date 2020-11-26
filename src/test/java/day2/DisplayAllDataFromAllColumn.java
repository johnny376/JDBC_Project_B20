package day2;

import utility.DB_Utility;

import java.sql.*;

public class DisplayAllDataFromAllColumn {

    public static void main(String[] args) throws SQLException {

        // we want to create a statement object that generate
        // ResultSet that can move forward and backward anytime
        DB_Utility.createConnection();
        ResultSet rs   =  DB_Utility.runQuery("SELECT * FROM EMPLOYEES") ;


        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

//        for (int colNum = 1; colNum < columnCount; colNum++) {
//            System.out.print(rsmd.getColumnLabel(colNum) + "\t");
//        }
//
//        System.out.println();
        rs.next();

        for (int colNum = 1; colNum < columnCount; colNum++) {
            System.out.print(rs.getString(colNum) + "\t");;
        }

        rs.beforeFirst();

        while(rs.next()){
            for (int colNum = 1; colNum < columnCount; colNum++) {
                System.out.print(rs.getString(colNum) + "\t");;
            }
            System.out.println();
        }

        //clean up the connection, statement and resultant object after usage:
        DB_Utility.destroy();


    }
}
