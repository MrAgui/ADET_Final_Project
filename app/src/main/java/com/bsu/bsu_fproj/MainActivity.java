package com.bsu.bsu_fproj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton new_student_btn;
    private TextView contact_us_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_us_btn = findViewById(R.id.contactUs);
        contact_us_btn.setOnClickListener(view -> showContactUs());

        new_student_btn = findViewById(R.id.new_Students);
        new_student_btn.setOnClickListener(view -> showDialog());
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