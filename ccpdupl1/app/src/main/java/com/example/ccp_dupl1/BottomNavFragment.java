package com.example.ccp_dupl1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BottomNavFragment extends Fragment {

    private ImageButton btnMain;
    private ImageButton btnTrend;
    private ImageButton btnCloset;
    private ImageButton btnCalibre;
    private ImageButton btnMypage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_bottom_nav, container, false);
        btnMain = rootView.findViewById(R.id.nav_button_my);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnTrend = rootView.findViewById(R.id.nav_button_my);
        btnTrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnCloset = rootView.findViewById(R.id.nav_button_my);
        btnCloset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnCalibre = rootView.findViewById(R.id.nav_button_my);
        btnCalibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnMypage = rootView.findViewById(R.id.nav_button_my);
        btnMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return rootView;
    }
}
