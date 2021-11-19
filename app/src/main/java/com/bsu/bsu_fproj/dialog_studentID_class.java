package com.bsu.bsu_fproj;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog_studentID_class extends AppCompatDialogFragment {

    private int profileID;

     /*Made a method called newInstance to create an instance with arguments */
    static dialog_studentID_class newInstance(int id){
        dialog_studentID_class f = new dialog_studentID_class();

        Bundle args = new Bundle();
        args.putInt("profile", id);
        f.setArguments(args);

        return f;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        System.out.println("checking statement");
       /* profileName = getArguments().getString("profile");*/


        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_studentid, null);
//
        ImageView n = (ImageView) v.findViewById(R.id.dialog_studentid_img);
        n.setImageResource(profileID);



        //btn listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("onClick", "clicked");
            }
        };


        // alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("Student ID")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();

    }
}