package com.example.ccp_dupl1;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.LinearLayout;

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

    public void onFragmentChange(int fragmentNum, Object args) {
        switch (fragmentNum) {
            case AppConstants.CALIBRE_BACK_BUTTON_CLICKED: {
                CalibreFragment CalibreFragment = new CalibreFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_current_page, CalibreFragment).commit();
                break;
            }
            case AppConstants.CALIBRE_SPECIFIC_BUTTON_CLICKED:
            case AppConstants.CALIBRE_STYLE_SPECIFIC_BACK_BUTTON_CLICKED: {
                CalibreSimilarImagesFragment similarImagesFragment = new CalibreSimilarImagesFragment((int)args);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_current_page, similarImagesFragment).commit();
                break;
            }
            case AppConstants.CALIBRE_RELATED_IMAGE_CLICKED: {
                CalibreStyleSpecificInfoFragment specificInfoFragment = new CalibreStyleSpecificInfoFragment((Bitmap)args);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_current_page, specificInfoFragment).commit();
                break;
            }
        }
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
