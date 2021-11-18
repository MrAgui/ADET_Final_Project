package com.bsu.bsu_fproj;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;

public class liabilities_class extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){


        // view
        View v= LayoutInflater.from(getActivity())
                .inflate(R.layout.liabilities_dialog, null);


        //btn listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("onClick", "clicked");
            }
        };


        // alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("Changin msg")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();

    }
}
