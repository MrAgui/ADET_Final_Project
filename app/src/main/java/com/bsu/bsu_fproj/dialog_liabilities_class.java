package com.bsu.bsu_fproj;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;

public class dialog_liabilities_class extends DialogFragment {

    private String payment;

    /* Made a method called newInstance to create an instance with arguments */
    public static dialog_liabilities_class newInstance(String recieved_payment_from_home){
        dialog_liabilities_class f = new dialog_liabilities_class();

        Bundle args = new Bundle();
        args.putString("payment", recieved_payment_from_home);
        f.setArguments(args);

        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

//        TRIAL AND ERROR
//        AlertDialog dialog = new AlertDialog(this);
//        if (getDialog() != null && getDialog().getWindow() != null) {
//            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        }
        System.out.println("checking statement");
        payment = getArguments().getString("payment");

        System.out.print("Successfully passed the "+payment);

        int id = getResources().getIdentifier("dialog_liabilities_"+payment, "layout", getActivity().getPackageName());
        View v = LayoutInflater.from(getActivity()).inflate(id, null);

        // view
        System.out.println("entering statements");

        //btn listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("onClick", "clicked");
            }
        };

        // alert dialog
        return new AlertDialog.Builder(getActivity())
        //.setTitle("Liabilities")

                .setView(v)

        //.setPositiveButton(android.R.string.ok, listener)
                .create();

    }
}
