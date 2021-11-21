package com.bsu.bsu_fproj.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.FragmentHomeBinding;
import com.bsu.bsu_fproj.dialog_liabilities_class;
import com.bsu.bsu_fproj.ui.menu_curriculum.CurriculumFragment;
import com.bsu.bsu_fproj.ui.menu_grades.GradesFragment;
import com.bsu.bsu_fproj.ui.menu_subjects.SubjectsFragment;



public class HomeFragment extends Fragment {

    /*private HomeViewModel homeViewModel;*/
    private FragmentHomeBinding binding;
    private String payment;

//    public static HomeFragment newInstance(String s){
//        HomeFragment f = new HomeFragment();
//
//        Bundle args = new Bundle();
//        args.putString("payment", s);
//        f.setArguments(args);
//        return f;
//    }
//

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

        binding.curriculum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment curriculumFragment = new CurriculumFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_home,curriculumFragment );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        /*BUNDLE ARGUMENT RECEIVER*/
//        Bundle payArgs = this.getArguments();
//        if (payArgs != null){
//            this.payment = payArgs.getString("pay");
//        }


//        payment = getArguments().getString("payment");
        System.out.println(payment + "after Nav to HomeFrag");
        binding.liabilitiesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                payment = getArguments().getString("payment");
                System.out.println(payment + "after Nav to HomeFrag clicked");
//                dialog_liabilities_class lia_dialog = new dialog_liabilities_class().newInstance(payment);
//                dialog_liabilities_class lia_dialog = new dialog_liabilities_class();
//                lia_dialog.show(getChildFragmentManager(),"Dialog Liabilities");
                new dialog_liabilities_class().newInstance("unpaid").show(getChildFragmentManager(),"Liabilities Dialog");
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

//        NavActivity dia = new NavActivity();
//        dia.setupSetMessage();


    }



//    View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
//    private void setupSetMessage(){
//        ImageButton btn = (ImageButton) v.findViewById(R.id.liabilities_btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                payment = getArguments().getString("payment");
//                FragmentManager manager = getActivity().getSupportFragmentManager();
//                HomeFragment dialog = new HomeFragment();
//
//                dialog.show(manager, "msgDial");
//                dialog.
//            }
//        });
//    }



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