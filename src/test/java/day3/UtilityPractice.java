package day3;

import utility.DB_Utility;

import java.sql.ResultSet;

public class UtilityPractice {

    public static void main(String[] args) {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT* FROM JOBS");




    }
}
