package com.example.ccp_dupl1;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalibreStyleSpecificInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalibreStyleSpecificInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton btnBack;
    private ImageView imageSelectedStyle;
    private RecyclerView gridStyleSpecific;

    private MainActivity mainActivity;
    private Bitmap clickedImage;

    public CalibreStyleSpecificInfoFragment() {
        // Required empty public constructor
    }
    public CalibreStyleSpecificInfoFragment(Bitmap clickedImage) {
        this.clickedImage = clickedImage;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrendStyleSpecificInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalibreStyleSpecificInfoFragment newInstance(String param1, String param2) {
        CalibreStyleSpecificInfoFragment fragment = new CalibreStyleSpecificInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_calibre_style_specific_info, container, false);

        btnBack = (ImageButton) rootView.findViewById(R.id.button_to_similar);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(AppConstants.CALIBRE_STYLE_SPECIFIC_BACK_BUTTON_CLICKED, 0);
            }
        });
        imageSelectedStyle = (ImageView) rootView.findViewById(R.id.image_selcted_specific);
        imageSelectedStyle.setImageBitmap(clickedImage);

        return rootView;
    }
}