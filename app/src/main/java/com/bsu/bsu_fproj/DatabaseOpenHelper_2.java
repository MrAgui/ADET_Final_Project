package com.bsu.bsu_fproj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper_2  extends SQLiteOpenHelper {
    private static final String DB_name = "student_info.db";
    private static  final int DB_version = 1;

    public DatabaseOpenHelper_2(Context context){
        super(context, DB_name, null, DB_version  );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
