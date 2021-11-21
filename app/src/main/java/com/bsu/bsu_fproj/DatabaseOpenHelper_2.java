package com.bsu.bsu_fproj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper_2  extends SQLiteOpenHelper {
    private static final String DB_name = "student_DB.db";
    private static  final int DB_version = 2;

    public DatabaseOpenHelper_2(Context context){
        super(context, DB_name, null, DB_version  );

    System.out.println(DB_name);

    }
//    @Override
//    public void onCreate(SQLiteDatabase DB) {
//
//        DB.execSQL ("create table student_tbl ("+
//                "sr_code TEXT NOT NULL UNIQUE,"+
//                "last_Name	TEXT NOT NULL,"+
//                "first_Name	TEXT NOT NULL,"+
//                "middle_Initial	TEXT,"+
//                "program	TEXT NOT NULL,"+
//                "yr_Level	NUMERIC NOT NULL,"+
//                "password	TEXT NOT NULL,"+
//                "liabilities	INTEGER NOT NULL,"+
//                "picture BLOB NOT NULL,"+
//                "PRIMARY KEY ('sr_code'))");
//
//        DB.execSQL("insert into student_tbl Values "+
//                "( '19-08638' , 'Aguilar', 'Karl', 'A', 'Computer Science', 'Second Year', 'asdada', '100' ),  " +
//                "( '19-06341' , 'Patacsil', 'Jhone Jhee', 'M', 'Computer Science', 'Second Year', 'qwerty', '200' )" );
//
//    }
    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL ("create table student_tbl ("+
                "sr_code VARCHAR(8) NOT NULL UNIQUE,"+
                "last_Name	    TEXT NOT NULL,"+
                "first_Name	    TEXT NOT NULL,"+
                "middle_Initial	TEXT,"+
                "program	    TEXT NOT NULL,"+
                "yr_Level	    NUMERIC NOT NULL,"+
                "password	    TEXT NOT NULL,"+
                "liabilities	TEXT NOT NULL,"+
                "PRIMARY KEY ('sr_code'))");

        DB.execSQL("insert into student_tbl Values "+
                "( '1908638' , 'Aguilar', 'Karl', 'A', 'Computer Science', 'Third Year', 'AGUILAR', 'paid'),  " +
                "( '1906341' , 'Patacsil', 'JhoneJhee', 'M', 'Computer Science', 'Third Year', 'PATACSIL', 'unpaid')," +
                "( '1906796' , 'Care', 'Joshua', 'K', 'Computer Science', 'Third Year', 'CARE', 'unpaid')," +
                "( '1947555' , 'Pacis', 'Christine', 'J', 'Computer Science', 'Third Year', 'PACIS', 'paid')");
/*
        Create table for GRADES, SUBJECTS, liabilities.
*/
        /*END UPDATE CODES HERE*/

        /* LIABILITIES */
//        DB.execSQL("create table liabilities_tbl("+
//        ""
//                );
        /* LIABILITIES */



        /*START UPDATE CODES HERE*/
/*        DB.execSQL("create table subjects_tbl ("+
                    "sr_code VARCHAR (8) NOT NULL UNIQUE,"+
                    "subject_1 TEXT NOT NULL," +
                    "subject_2 TEXT NOT NULL," +
                    "subject_3 TEXT NOT NULL," +
                    "subject_4 TEXT NOT NULL," +
                    "subject_5 TEXT NOT NULL," +
                    "subject_6 TEXT NOT NULL," +
                    "subject_7 TEXT NOT NULL )");

        DB.execSQL("insert into subjects_tbl VALUES " +
                "('1', 'Automata Theory and Formal Languages', 'Mobile Computing', 'Human-Computer Interaction', 'Web Systems and Technologies', 'Application Development and Emerging Technologies', 'Data Analysis', 'The Contemporary World'),"+
                "('2', 'Automata Theory and Formal Languages', 'Mobile Computing', 'Human-Computer Interaction', 'Web Systems and Technologies', 'Application Development and Emerging Technologies', 'Data Analysis', 'The Contemporary World')");

        DB.execSQL("create table grades_tbl("+
                "sr_code VARCHAR (8) NOT NULL UNIQUE,"+
                "grades_1 TEXT NOT NULL," +
                "grades_2 TEXT NOT NULL," +
                "grades_3 TEXT NOT NULL," +
                "grades_4 TEXT NOT NULL," +
                "grades_5 TEXT NOT NULL," +
                "grades_6 TEXT NOT NULL," +
                "grades_7 TEXT NOT NULL )");

        */


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists student_tbl");


    }
}
