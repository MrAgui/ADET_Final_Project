//package com.bsu.bsu_fproj;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.text.Editable;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class LoginActivity extends MainActivity {
//    public Button btn_sign_in;
//    public EditText inputSrcode;
//    public EditText inputPassword;
//    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);
//
//    public void loginFunction(){
//        btn_sign_in = findViewById(R.id.btn_sign_in);
//        inputSrcode = findViewById(R.id.inputSrcode);
//        inputPassword = findViewById(R.id.inputPassword);
//
//
//        btn_sign_in.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                SQLiteDatabase db = dbHelper.getReadableDatabase();
//                System.out.println("Executed Here");
//                Cursor c = null;
//                Editable ESr_code = inputSrcode.getText();
//                Editable EPassword = inputPassword.getText();
//                String sr_code = ESr_code.toString().replaceAll("\\s+$", ""); //removes end spaces (search replaceall syntax if have questions)
//                String password = EPassword.toString();
//
//                try {
//                    db = dbHelper.getReadableDatabase();
//                    c = db.rawQuery("select * from student_info where sr_code='" + sr_code + "' AND password='" + password + "'", new String[]{});
//
//                } finally {
//                    //do nothing
//                }
//
//                System.out.println("checking fields");
//                // checking the inputs in login
//                if (c.moveToFirst() == false){
//                    //output dialog
//                    System.out.println("Username and password does not match");
//                }
//
//                /* Start EDIT TEST */
//                else {
//                    try {
//                        db = dbHelper.getReadableDatabase();
//                        c = db.rawQuery("select * from student_info where sr_code='"+ sr_code +"' AND password='"+ password +"'", new String[]{});
//                        c.moveToFirst();
//                        do {
//
//
//
//                            // https://stackoverflow.com/questions/3105080/output-values-found-in-cursor-to-logcat-android/13106260
//
//                        /*StringBuilder sb = new StringBuilder();
//                        int columnsQty = c.getColumnCount();
//                        for (int idx=0; idx<columnsQty; ++idx) {
//                            sb.append(c.getString(idx));
//                            if (idx < columnsQty - 1)
//                                sb.append("; ");
//                        }
//                        Log.v("Test", String.format("Row: %d, Values: %s", c.getPosition(),
//                                sb.toString()));
//
//                         */
//
//
//                            System.out.println("--------");
//                            for(int i=0;i<8;i++){
//                                System.out.println( c.getString(i));
//                            }
//                            System.out.println("--------");
//                            //System.out.println( c.getString(0));
//                        } while (c.moveToNext());
//                        db.close();
//                        //String sr_code = c.getString(0);
//
//                        //return cursor.getInt(0) > 0;
//                    } finally {
//
//                        //close(c, db);
//                    }
//                    openPortal();
//                }
//                //"select * from student_info; "
//
//
//
//                //    Select query       https://guides.codepath.com/android/local-databases-with-sqliteopenhelper
//
//
///*                c = db.rawQuery("select password from student_Info where sr_code = '" + sr_code + "'", new String[]{});
//        StringBuffer buffer = new StringBuffer();
//        while(c.moveToNext()){
//            String password = c.getString(0);
//            buffer.append(""+password);
//        }*/
//// Define a projection that specifies which columns from the database
//// you will actually use after this query.
//
//                /* END EDIT TEST */
//
//
//            }
//        });
//    }
//
//
//}
