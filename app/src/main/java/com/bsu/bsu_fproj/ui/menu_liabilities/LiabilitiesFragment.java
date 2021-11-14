package com.bsu.bsu_fproj.ui.menu_liabilities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsu.bsu_fproj.R;

public class LiabilitiesFragment extends Fragment {

    private LiabilitiesViewModel mViewModel;

    public static LiabilitiesFragment newInstance() {
        return new LiabilitiesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_liabilities_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LiabilitiesViewModel.class);
        // TODO: Use the ViewModel
    }

}