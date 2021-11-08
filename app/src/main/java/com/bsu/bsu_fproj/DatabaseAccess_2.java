package com.bsu.bsu_fproj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess_2 {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess_2 instance;
    Cursor c = null;

    private DatabaseAccess_2 (Context context){
        this.openHelper=new DatabaseOpenHelper_2(context);
    }

    public static DatabaseAccess_2 getInstance (Context context){
            if (instance==null){
                instance=new DatabaseAccess_2(context);
            }
            return instance;
    }
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }
}
