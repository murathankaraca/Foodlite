package com.eray.foodlite;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.eray.foodlite.Fragments.BasketFragment;
import com.eray.foodlite.Fragments.HomeFragment;
import com.eray.foodlite.Fragments.ProfileFragment;
import com.eray.foodlite.Fragments.SearchFragment;
import com.eray.enbuyukfener.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondaryActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private TextView toolbarTitle;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarTitle = findViewById(R.id.title);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                //toolbarTitle.setText(R.string.tab_home);
                break;
            case R.id.nav_profil:
                fragment = new ProfileFragment();
                //toolbarTitle.setText(R.string.tab_profile);
                break;
            case R.id.nav_sepet:
                fragment = new BasketFragment();
                //toolbarTitle.setText(R.string.tab_bucket);
                break;
            case R.id.nav_search:
                fragment = new SearchFragment();
                //toolbarTitle.setText(R.string.tab_search);
                break;

        }
        return loadFragment(fragment);
    }
}
