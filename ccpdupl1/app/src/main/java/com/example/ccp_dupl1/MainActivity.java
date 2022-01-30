package com.example.ccp_dupl1;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String TAG = this.getClass().getSimpleName();

    LinearLayout homeLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        SettingListener();
        bottomNavigationView.setSelectedItemId(R.id.tab_home);
    }

    private void init()
    {
        homeLayout = (LinearLayout)findViewById(R.id.fragment_current_page);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    private void SettingListener()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener());
    }


//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }

    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()) {
                case R.id.tab_home: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_current_page, new HomeFragment()).commit();
                    return true;
                }
                case R.id.tab_trend: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_current_page, new TrendFragment()).commit();
                    return true;
                }
                case R.id.tab_closet: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_current_page, new ClosetFragment()).commit();
                    return true;
                }
                case R.id.tab_calibre: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_current_page, new CalibreFragment()).commit();
                    return true;
                }
                case R.id.tab_mypage: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_current_page, new MypageFragment()).commit();
                    return true;
                }
            }
            return false;
        }
    }

}
