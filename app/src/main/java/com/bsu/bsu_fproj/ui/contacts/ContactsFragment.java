package com.bsu.bsu_fproj.ui.contacts;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.FragmentContactsBinding;


public class ContactsFragment extends Fragment {




    private ContactsViewModel contactsViewModel;

    private TextView trunklines_contacts;
    private TextView registrar_contacts;
    private TextView ict_services_contacts;


    /* Change the Fragment in Binding declaration */
    private FragmentContactsBinding binding;
    /*    previous version
    private FragmentGalleryBinding binding;*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactsViewModel =
                new ViewModelProvider(this).get(ContactsViewModel.class);

//        trunklines_contacts.findViewById(R.id.trunklines);
//        trunklines_contacts.setOnClickListener(view -> showtrunklines());



        // changes in here
        binding = FragmentContactsBinding.inflate(inflater, container, false);

        View root = inflater.inflate(R.layout.fragment_contacts, container, false);


        return root;

    }

//
//    private void showtrunklines(){
//        Dialog dialog = new Dialog (ContactsFragment.this);
//        dialog.setContentView(R.layout.new_student_dialog);
//        dialog.getWindow().setBackgroundDrawableResource(R.drawable.new_student_dialog_bg);
//        dialog.show();
//    }
}