package com.bsu.bsu_fproj.ui.links;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.FragmentLinksBinding;
import com.bsu.bsu_fproj.ui.links.LinksViewModel;

public class LinksFragment extends Fragment  {

    private LinksViewModel linksViewModel;


    /*public static LinksFragment newInstance() {
        return new LinksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_links, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LinksViewModel.class);
        // TODO: Use the ViewModel
    }*/


    private FragmentLinksBinding binding;
/*    previous version
    private FragmentGalleryBinding binding;*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        linksViewModel =
                new ViewModelProvider(this).get(LinksViewModel.class);

        // changes in here
        binding = FragmentLinksBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View root = inflater.inflate(R.layout.fragment_links, container, false);

//        final TextView textView = root.findViewById(R.id.text_contacts);

        // changes in here
        /*final TextView textView = binding.textLinks;
        linksViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

}