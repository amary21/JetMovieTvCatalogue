package com.amary.app.data.jetmovietvcat.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.ui.movie.MovieFragment;
import com.amary.app.data.jetmovietvcat.ui.tv.TvShowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class HomeActivity extends AppCompatActivity {
    private final String SELECTED_MENU = "selected_menu";
    private BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.navigation_movie) {
            fragment = MovieFragment.newInstance();
        } else if (item.getItemId() == R.id.navigation_tvshows) {
            fragment = TvShowFragment.newInstance();
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit();
        }
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState != null){
            savedInstanceState.getInt(SELECTED_MENU);
        }else {
            navView.setSelectedItemId(R.id.navigation_movie);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_MENU, navView.getSelectedItemId());
    }
}
