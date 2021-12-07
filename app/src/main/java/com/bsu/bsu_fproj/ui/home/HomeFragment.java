package com.bsu.bsu_fproj.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.FragmentHomeBinding;
import com.bsu.bsu_fproj.dialog_liabilities_class;
import com.bsu.bsu_fproj.dialog_studentID_class;
import com.bsu.bsu_fproj.ui.menu_curriculum.CurriculumFragment;
import com.bsu.bsu_fproj.ui.menu_grades.GradesFragment;
import com.bsu.bsu_fproj.ui.menu_subjects.SubjectsFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private static String payment;
    private static String usr;

    // for carousel
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3, R.drawable.carousel4};

    // Getting the data from NavActivity (line  189)
    public static HomeFragment newInstance(String s, String sr){
        payment = s;
        usr = sr;
        HomeFragment f = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("payment", s);
        f.setArguments(args);
        System.out.println("SUCCESS" + s);
        return f;

    }

//    public static HomeFragment newInstance(String i){
//        payment = i;
//        HomeFragment f = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString("payment", i);
//        f.setArguments(args);
//        System.out.println("SUCCESS" + i);
//        return f;
//
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


//    Made a new method onViewCreated create all the click listener for the buttons
//    When the view is displayed,
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);



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
                System.out.println("Clicked Grades");
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


        binding.liabilitiesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(payment + " after Nav to HomeFrag clicked");
//                dialog_liabilities_class lia_dialog = new dialog_liabilities_class().newInstance(payment);
//                lia_dialog.show(getChildFragmentManager(),"Dialog Liabilities");
                new dialog_liabilities_class().newInstance(payment).show(getChildFragmentManager(),"Liabilities Dialog");
                System.out.println(payment);
            }
        });

        binding.studentIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    showID();
//                System.out.println("this is student ID");

//                dialog_studentID_class dialogID = new dialog_studentID_class().newInstance(usr);
//                dialogID.show(getChildFragmentManager(),"Student ID Dialog");
                new dialog_studentID_class().newInstance(usr).show(getChildFragmentManager(),"Student ID Dialog");
//                new dialog_studentID_class().newInstance().show(getChildFragmentManager(), "Student ID Dialog");
//                dialogID.setContentView(R.layout.dialog_stud_id);
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showID(){

/*
        Dialog dialog=new Dialog();
        dialog.setContentView(R.layout.dialog_stud_id);
        dialog.getWindow().setBackgroundDrawableResource(new ColorDrawable(Color.TRANSPARENT));

        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(),"Custom Dialog");
*/



    }

}