package com.sanjays.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//         # 1 bottom nav
        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListener);


//        setting home fragments as main fragment as well as default fragments
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout,new HomeFragment()).commit();

    }


//   #2 listenert nav bar

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

//          #3  to create fragements for each

            switch  (item.getItemId()){
                case R.id.item1:
                     selectedFragment = new HomeFragment();
                     break;
                case R.id.item2:
                    selectedFragment = new AchievementFragment();
                    break;
                case R.id.item3:
                    selectedFragment = new SettingsFragment();
                    break;


            }

//           #4  begin transaction
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout,selectedFragment).commit();
            return true;
        }
    };
}