//package com.bsu.bsu_fproj;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DatabaseAccess {
//    private SQLiteOpenHelper openHelper;
//    private SQLiteDatabase db;
//    private static DatabaseAccess instance;
//    Cursor c = null;
//
//    private DatabaseAccess(Context context) {
//        this.openHelper = new DatabaseOpenHelper(context);
//    }
//
//    public static DatabaseAccess getInstance(Context context) {
//        if (instance == null) {
//            instance = new DatabaseAccess(context);
//
//        }
//        return instance;
//    }
//
//    public void open() {
//        this.db = openHelper.getWritableDatabase();
//    }
//
//    public void close() {
//        if (db != null) {
//            this.db.close();
//        }
//    }
//
////    public boolean exist(String user){
////    c = db.rawQuery("select sr_code from student_Info where sr_code = '" + user + "'", new String[]{});
////    String srCheck;
////    srCheck = c.getString(0);
////
////    if (user == srCheck){
////        return true;
////    }
////    else
////        return false;
////    }
////
////    // Getter Method - Get Password from database
////    public String getPassword(String sr_code){
////        c = db.rawQuery("select password from student_Info where sr_code = '" + sr_code + "'", new String[]{});
////        StringBuffer buffer = new StringBuffer();
////        while(c.moveToNext()){
////            String password = c.getString(0);
////            buffer.append(""+password);
////        }
////        return buffer.toString();
////    }
//
////    public boolean exist(String user) {
////        open();
////        c = db.rawQuery("select * from student_Info where sr_code = ?", new String[]{user});
////        if (c.getCount() > 0) {
////            close();
////            return true;
////        } else{
////            close();
////            return false;
////        }
////
////    }
//
//}
