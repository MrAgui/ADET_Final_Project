package com.bsu.bsu_fproj.ui.contacts;

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
import com.bsu.bsu_fproj.databinding.FragmentGalleryBinding;

public class ContactsFragment extends Fragment {




    private ContactsViewModel contactsViewModel;

    /* Change the Fragment in Binding declaration */
    private FragmentContactsBinding binding;
/*    previous version
    private FragmentGalleryBinding binding;*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactsViewModel =
                new ViewModelProvider(this).get(ContactsViewModel.class);



        // changes in here
        binding = FragmentContactsBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

//        final TextView textView = root.findViewById(R.id.text_contacts);

        // changes in here
        final TextView textView = binding.textContacts;
        contactsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}