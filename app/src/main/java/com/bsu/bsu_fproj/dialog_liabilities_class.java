package com.bsu.bsu_fproj;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog_liabilities_class extends AppCompatDialogFragment {

    private String payment;

    /* Made a method called newInstance to create an instance with arguments */
    static dialog_liabilities_class newInstance(String s){
        dialog_liabilities_class f = new dialog_liabilities_class();

        Bundle args = new Bundle();
        args.putString("payment", s);
        f.setArguments(args);

        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        System.out.println("checking statement");
        payment = getArguments().getString("payment");

        int id = getResources().getIdentifier("dialog_liabilities_"+payment, "layout", getActivity().getPackageName());
        View v = LayoutInflater.from(getActivity()).inflate(id, null);
//


        System.out.println(payment + "liability");


        // view
        System.out.println("entering statements");
        /*if (payment == "paid"){
            v = LayoutInflater.from(getActivity())
                    .inflate(R.layout.dialog_liabilities_paid, null);
            System.out.println("THIS IS PAID");
        }
        else if (payment == "unpaid"){
            v = LayoutInflater.from(getActivity())
                    .inflate(R.layout.dialog_liabilities_unpaid, null);
            System.out.println("THIS IS UNPAID");
        }*/


        //btn listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("onClick", "clicked");
            }
        };


        // alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("Liabilities")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();

    }
}
