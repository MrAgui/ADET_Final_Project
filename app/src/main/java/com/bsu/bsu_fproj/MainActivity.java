package com.bsu.bsu_fproj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /* things to do navigation change the label, edit the UI for BSU theme */


    private ImageButton new_student_btn;
    private TextView contact_us_btn;
    public Button btn_sign_in;
    public EditText inputSrcode;
    public EditText inputPassword;

    // Storing Data inside variables to be used in the user profile

//    public String sr_codeHolder, first_NameHolder;




    DatabaseOpenHelper_2 dbHelper = new DatabaseOpenHelper_2(this);
    public String[] student_data = {"","","","","","","",""};


    private static final String TAG = "MainActivity";

    String sr_code;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i(TAG, "On create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "On Start");
        contact_us_btn = findViewById(R.id.contactUs);
        contact_us_btn.setOnClickListener(view -> showContactUs());

        new_student_btn = findViewById(R.id.new_Students);
        new_student_btn.setOnClickListener(view -> showDialog());

        btn_sign_in = findViewById(R.id.btn_sign_in);

        inputSrcode = findViewById(R.id.inputSrcode);
        inputPassword = findViewById(R.id.inputPassword);


        btn_sign_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                System.out.println("Executed Here");
                Cursor c = null;
                Editable ESr_code = inputSrcode.getText();
                Editable EPassword = inputPassword.getText();

                System.out.println("getting inputs");

                sr_code = ESr_code.toString().replaceAll("\\s+$", ""); //removes end spaces (search replaceall syntax if have questions)
                password = EPassword.toString();
                try {
                    db = dbHelper.getReadableDatabase();
                    c = db.rawQuery("select * from student_tbl where sr_code='" + sr_code + "' AND password='" + password + "'", new String[]{});

                }catch(SQLiteException e) {
                    System.out.println(e.toString()); // change by jhone jhee
                }
                finally {

                }

                System.out.println("checking fields");

                // checking the inputs in login
                if (c.moveToFirst() == false) {

                    //outputs dialog when error in logging in
                    Toast.makeText(MainActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
                    System.out.println("Username and password does not match");

                } else {
                    try {
                        db = dbHelper.getReadableDatabase();
                        c = db.rawQuery("select * from student_tbl where sr_code='" + sr_code + "' AND password='" + password + "'", new String[]{});
                        c.moveToFirst();
                        do {
                            // https://stackoverflow.com/questions/3105080/output-values-found-in-cursor-to-logcat-android/13106260
                            System.out.println("--------");
                            for (int i = 0; i < 8; i++) {
//                                student_data[i] = c.getString(i);
//                                System.out.println(student_data[i]);
                            }
                            System.out.println("--------");
//                            System.out.println( c.getString(0));
                        } while (c.moveToNext());

                        db.close();

                    } finally {

                    }
                    openPortal();
                }
                //    Select query   https://guides.codepath.com/android/local-databases-with-sqliteopenhelper
                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on Resume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "On Restart");
    }

    public void openPortal() {
        Intent intent = new Intent(this, NavActivity.class);
        intent.putExtra("name", sr_code);
        System.out.println(sr_code);
        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
        startActivity(intent);
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
