package com.bsu.bsu_fproj.ui.links;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bsu.bsu_fproj.R;
import com.bsu.bsu_fproj.databinding.FragmentLinksBinding;

public class LinksFragment extends Fragment  {

    private LinksViewModel linksViewModel;
    TextView linkTextView;

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
        binding = FragmentLinksBinding.inflate(getLayoutInflater());
        return binding.getRoot();
//        linksViewModel =
//                new ViewModelProvider(this).get(LinksViewModel.class);

        // changes in here
//        binding = FragmentLinksBinding.inflate(inflater, container, false);
////        View root = binding.getRoot();
//        View root = inflater.inflate(R.layout.fragment_links, container, false);

//        final TextView textView = root.findViewById(R.id.text_contacts);

        // changes in here
        /*final TextView textView = binding.textLinks;
        linksViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        /*CODE FOR LINKS*/

//        linkTextView = linkTextView.findViewById(R.id.textView2);
//        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        /*BetterLinkMovementMethod.linkify(Linkify.ALL,binding.textView2)
                .setOnLinkClickListener(new BetterLinkMovementMethod.OnLinkClickListener() {
                    @Override
                    public boolean onClick(TextView textView, String url) {
                        if (url.contains("I (MAIN)"))
                            Toast.makeText(getActivity(), "Website:"+url, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });*/

        /*END CODE FOR LINKS*/
//        return root;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        System.out.println("Check link state ");
//        binding.textView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openUrl("https://www.facebook.com/sscmain1");
//                System.out.print("Clicked Link 1");
//
//            }
//        });
        binding.textView2.setText(Html.fromHtml(getString(R.string.linkSSCPBC1)));
        binding.textView2.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView3.setText(Html.fromHtml(getString(R.string.linkSSCPBC2)));
        binding.textView3.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView4.setText(Html.fromHtml(getString(R.string.linkSSCARASOF)));
        binding.textView4.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView5.setText(Html.fromHtml(getString(R.string.linkSSCBALAYAN)));
        binding.textView5.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView6.setText(Html.fromHtml(getString(R.string.linkSSCLEMERY)));
        binding.textView6.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView7.setText(Html.fromHtml(getString(R.string.linkSSCROSARIO)));
        binding.textView7.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView8.setText(Html.fromHtml(getString(R.string.linkSSCLIPA)));
        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView9.setText(Html.fromHtml(getString(R.string.linkSSCSANJUAN)));
        binding.textView9.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView10.setText(Html.fromHtml(getString(R.string.linkSSCLOBO)));
        binding.textView10.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView11.setText(Html.fromHtml(getString(R.string.linkSSCJPLPCMALVAR)));
        binding.textView11.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView13.setText(Html.fromHtml(getString(R.string.linkSOFPCAMERACLUB)));
        binding.textView13.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView14.setText(Html.fromHtml(getString(R.string.linkSOFPKAMARA)));
        binding.textView14.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView15.setText(Html.fromHtml(getString(R.string.linkSOFPSONS)));
        binding.textView15.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView16.setText(Html.fromHtml(getString(R.string.linkSOFPCEAFA)));
        binding.textView16.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView17.setText(Html.fromHtml(getString(R.string.linkSOFPJIECEP)));
        binding.textView17.setMovementMethod(LinkMovementMethod.getInstance());

        binding.textView18.setText(Html.fromHtml(getString(R.string.linkSOFPJIIEE)));
        binding.textView18.setMovementMethod(LinkMovementMethod.getInstance());

    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

    /* For Links */
    private void openUrl(String url){
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}