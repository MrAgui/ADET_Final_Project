package com.bsu.bsu_fproj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton new_student_btn;
    private TextView contact_us_btn;
    public Button btn_sign_in;
    public EditText inputSrcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(this, null, null, 1);

        contact_us_btn = findViewById(R.id.contactUs);
        contact_us_btn.setOnClickListener(view -> showContactUs());

        new_student_btn = findViewById(R.id.new_Students);
        new_student_btn.setOnClickListener(view -> showDialog());

        btn_sign_in = findViewById(R.id.btn_sign_in);

        inputSrcode = findViewById(R.id.inputSrcode);


///// probably error

        btn_sign_in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputSrcode.setText(dbHelper.loadHandler());

//                String u = inputSrcode.getText().toString();
//                boolean enrolled = false;


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