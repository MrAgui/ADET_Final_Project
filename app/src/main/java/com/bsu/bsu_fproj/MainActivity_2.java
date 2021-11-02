package com.bsu.bsu_fproj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity_2 extends AppCompatActivity{

    private ImageButton new_student_btn;
    private TextView contact_us_btn;
    public Button btn_sign_in;
    public EditText inputSrcode;
    public EditText inputPassword;
    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);

    boolean isLoggedIn = false;
    final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Creating MainActivity Activity...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(this, null, null, 1);
        //DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);
    }

    @Override
    protected void onRestart(){
        System.out.println("Restarting MainActivity Instances...");
        super.onRestart();
    }

    @Override
    protected void onStart(){
        System.out.println("Starting MainActivity...");
        super.onStart();
        checkLogin();
        if(isLoggedIn){
            startLoginActivity();
        }
    }
    @Override
    protected void onResume(){
        System.out.println("Resuming MainActivity...");
        super.onResume();
    }
    @Override
    protected void onPause(){
        System.out.println("Pausing MainActivity...");
        super.onPause();
    }
    @Override
    protected void onStop(){
        System.out.println("Stopping MainActivity...");
        super.onStop();
        isLoggedIn = false;
    }
    @Override
    protected void onDestroy(){
        System.out.println("Destroying MainActivity...");
        super.onDestroy();
    }

    public void checkLogin(){
        if(isLoggedIn==true){
            Log.d(TAG, "Student is logged in.");
        }else{
            Log.d(TAG, "Student is logged out.");

        }
    }

    public void startLoginActivity(){
        contact_us_btn = findViewById(R.id.contactUs);
        contact_us_btn.setOnClickListener(view -> showContactUs());

        new_student_btn = findViewById(R.id.new_Students);
        new_student_btn.setOnClickListener(view -> showDialog());

        btn_sign_in = findViewById(R.id.btn_sign_in);

        inputSrcode = findViewById(R.id.inputSrcode);
        inputPassword = findViewById(R.id.inputPassword);

        btn_sign_in.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view){
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                System.out.println("Executed Here");
                Cursor c = null;
                Editable ESr_code = inputSrcode.getText();
                Editable EPassword = inputPassword.getText();
                String sr_code = ESr_code.toString().replaceAll("\\s+$", ""); //removes end spaces (search replaceall syntax if have questions)
                String password = EPassword.toString();

                try {
                    db = dbHelper.getReadableDatabase();
                    c = db.rawQuery("select * from student_info where sr_code='" + sr_code + "' AND password='" + password + "'", new String[]{});

                } finally {
                    //do nothing
                }

                System.out.println("checking fields");
                // checking the inputs in login
                if (c.moveToFirst() == false){
                    //output dialog
                    System.out.println("Username and password does not match");
                }


                else {
                    try {
                        db = dbHelper.getReadableDatabase();
                        c = db.rawQuery("select * from student_info where sr_code='"+ sr_code +"' AND password='"+ password +"'", new String[]{});
                        c.moveToFirst();
                        do {
                            // https://stackoverflow.com/questions/3105080/output-values-found-in-cursor-to-logcat-android/13106260
                            System.out.println("--------");
                            for(int i=0;i<8;i++){
                                System.out.println( c.getString(i));
                            }
                            System.out.println("--------");
                            //System.out.println( c.getString(0));
                        } while (c.moveToNext());
                        db.close();

                    } finally {


                    }
                    openPortal();
                }

                //    Select query       https://guides.codepath.com/android/local-databases-with-sqliteopenhelper
                // Define a projection that specifies which columns from the database
                // you will actually use after this query.

            }
        });
    }

    public void openPortal() {
        Intent intent = new Intent(this, activity_portal.class);
        startActivity(intent);
    }
    public void loginError(){
        Dialog dialog = new Dialog(this );
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.contact_us);
        dialog.show();
    }

    private void showContactUs(){
        Dialog dialog = new Dialog(this );
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.contact_us);
        dialog.show();
    }

    private void showDialog(){
        Dialog dialog = new Dialog (this);
        dialog.setContentView(R.layout.new_student_dialog);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.new_student_dialog_bg);
        dialog.show();
    }

}
