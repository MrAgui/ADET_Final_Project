package com.bsu.bsu_fproj.ui.menu_grades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.MenuGradesFragmentBinding;

public class GradesFragment extends Fragment {

    private GradesViewModel mViewModel;
    private MenuGradesFragmentBinding binding;
    private static String[] grades = {"","","","","","","",""};

    public static GradesFragment newInstance(String[] r_grade){
        System.out.println("Clicked grades");
        for (int i=0; i<8; i++){
            grades[i] = r_grade[i];
            System.out.println(grades[i]);
        }

        GradesFragment f = new GradesFragment();
        Bundle args = new Bundle();
//        args.putString("payment", s);
        f.setArguments(args);
//        System.out.println("SUCCESS" + s);
        return f;

    }

    public static GradesFragment newInstance() {
        return new GradesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        

        return inflater.inflate(R.layout.menu_grades_fragment, container, false);
//        binding = MenuGradesFragmentBinding.inflate(getLayoutInflater());
//        return binding.getRoot();
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    // Setting the receiveGrades to the TextView
        TextView CS_222 = (TextView) view.findViewById(R.id.CS_222);
        TextView CS_221 = (TextView) view.findViewById(R.id.CS_221);
        TextView ES_101 = (TextView) view.findViewById(R.id.ES_101);
        TextView GEd_107 = (TextView) view.findViewById(R.id.GEd_107);
        TextView IT_221 = (TextView) view.findViewById(R.id.IT_221);
        TextView ENGG_414 = (TextView) view.findViewById(R.id.ENGG_414);
        TextView GEd_106 = (TextView) view.findViewById(R.id.GEd_106);
        TextView PE_104 = (TextView) view.findViewById(R.id.PE_104);

        CS_222.setText(grades[0]);
        CS_221.setText(grades[1]);
        ES_101.setText(grades[2]);
        GEd_107.setText(grades[3]);
        IT_221.setText(grades[4]);
        ENGG_414.setText(grades[5]);
        GEd_106.setText(grades[6]);
        PE_104.setText(grades[7]);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(GradesViewModel.class);
//        // TODO: Use the ViewModel
//    }

}