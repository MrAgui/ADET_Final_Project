package com.bsu.bsu_fproj.ui.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bsu.bsu_fproj.NavActivity;
import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.FragmentHomeBinding;
import com.bsu.bsu_fproj.ui.dialogStudID;
import com.bsu.bsu_fproj.ui.menu_grades.GradesFragment;
import com.bsu.bsu_fproj.ui.menu_liabilities.LiabilitiesFragment;
import com.bsu.bsu_fproj.ui.menu_subjects.SubjectsFragment;

public class HomeFragment extends Fragment {

    /*private HomeViewModel homeViewModel;*/
    private FragmentHomeBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;*/


        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


//    Made a new method onViewCreated create all the click listener fot the buttons
//    When the view is displayed,
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        /* OnClick Listener methods */

        binding.subjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked Subjects");
                /*CREATED OBJECT FROM CLASS SubjectFragment*/
                Fragment subjectsFragment = new SubjectsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_home,subjectsFragment );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.grades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked Subjects");
                Fragment gradesFragment = new GradesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_home,gradesFragment );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

//        binding.liabilities_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment liabilitiesFragment = new LiabilitiesFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frag_home,liabilitiesFragment );
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//
//            }
//        });

        binding.curriculum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment curriculumFragment = new LiabilitiesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_home,curriculumFragment );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });




/*        binding.studentId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    showID();
                dialogStudID dialogID = new dialogStudID();
                dialogID.show(getSupportFragmentManager(),"Student ID Dialog");
                dialogID.setContentView(R.layout.dialog_stud_id);
            }
        });*/





    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showID(){

        /*Dialog dialog=new Dialog();
        dialog.setContentView(R.layout.dialog_stud_id);
        dialog.getWindow().setBackgroundDrawableResource(new ColorDrawable(Color.TRANSPARENT));*/

        /*CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(),"Custom Dialog");*/



    }

}