package com.bsu.bsu_fproj;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog_studentID_class extends AppCompatDialogFragment {

    private static String usr;

     /*Made a method called newInstance to create an instance with arguments */
    public static dialog_studentID_class newInstance(String sr){
        dialog_studentID_class f = new dialog_studentID_class();
        usr = sr;
        System.out.println("Success passing to studID class: "+usr);
        Bundle args = new Bundle();
        args.putString("profile", sr);
        f.setArguments(args);

        return f;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        System.out.println("checking statement");
       /* profileName = getArguments().getString("profile");*/
/* START EDIT*/

//        int id = getResources().getIdentifier("dialog_studentID_"+sr_code, "layout", getActivity().getPackageName());

/*END EDIT*/
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_studentid, null);
//
//         n = (ImageView) v.findViewById(R.layout.dialog_studentid_img);
//        n.setImageResource(profileID);



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