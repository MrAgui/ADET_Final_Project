package com.bsu.bsu_fproj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper_2  extends SQLiteOpenHelper {
    private static final String DB_name = "student_DB.db";
    private static  final int DB_version = 1;

    public DatabaseOpenHelper_2(Context context){
        super(context, DB_name, null, DB_version  );

    System.out.println(DB_name);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL ("create table student_tbl ("+
                "sr_code TEXT NOT NULL UNIQUE,"+
                "last_Name	TEXT NOT NULL,"+
                "first_Name	TEXT NOT NULL,"+
                "middle_Initial	TEXT,"+
                "program	TEXT NOT NULL,"+
                "yr_Level	NUMERIC NOT NULL,"+
                "password	TEXT NOT NULL,"+
                "liabilities	INTEGER NOT NULL,"+
                "PRIMARY KEY ('sr_code'))");

        DB.execSQL("insert into student_tbl Values "+
                "( '1' , 'Aguilar', 'Karl', 'A', 'Computer Science', 'Second Year', 'asdada', '100'),  " +
                "( '2' , 'Patacsil', 'Jhone Jhee', 'M', 'Computer Science', 'Second Year', 'qwerty', '200')" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists student_tbl");
    }
}
