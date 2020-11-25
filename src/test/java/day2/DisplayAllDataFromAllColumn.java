package day2;

import java.sql.*;

public class DisplayAllDataFromAllColumn {

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
//        rs.close();
//        stmt.close();
//        conn.close();




    }
}
