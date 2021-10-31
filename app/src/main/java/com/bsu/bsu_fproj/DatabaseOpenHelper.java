package com.bsu.bsu_fproj;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.*;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "student_info.db";
    private static final int DB_VER = 1;
    private static String DB_PATH = "/data/user/0/com.bsu.bsu_fproj/databases/";
    SQLiteDatabase myDB;
    private static Context mContext;

    public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DB_NAME, factory, DB_VER);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    private boolean checkDatabase(){
        try {
            final String mPath = DB_PATH + DB_NAME;
            final File file = new File(mPath);
            if (file.exists())
                return true;
            else
                return false;
        }
        catch(SQLiteException e){
            e.printStackTrace();
            return false;
        }
    }

    private void copyDatabase() throws IOException{
        try{
            InputStream mInputStream = mContext.getAssets().open(DB_NAME);
            String outFileName = DB_PATH + DB_NAME;
            OutputStream mOutputStream = new FileOutputStream(outFileName);

            byte buffer = new byte[1024];
            int length;
            while((length = mInputStream.read(buffer)) > 0){
                mOutputStream.write(buffer, 0, length);
            }
            mOutputStream.flush();
            mOutputStream.close();
            mInputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createDatabase() throws  IOException{
        boolean mDatabaseExist = checkDatabase();
        if(!mDatabaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                copyDatabase();
            }
            catch (IOException mIOException){
                mIOException.printStackTrace();
                throw new Error("Error copying Database");
            }
            finally {
                this.close();
            }
        }
    }

    @Override
    public synchronized void close(){
        if(myDB != null)
            myDB.close();
        SQLiteDatabase.releaseMemory();
        super.close();
    }

    public String loadHandler(){
        try{
            createDatabase();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("select * from student_Info where sr_code = 1", null);

        while(c.moveToNext()){
            String result = c.getString(6);
        }
        c.close();
        db.close();
        return result;
    }
}
