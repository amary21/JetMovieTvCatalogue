package com.amary.app.data.jetmovietvcat.testing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.amary.app.data.jetmovietvcat.R;

@SuppressLint("Registered")
public class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new FrameLayout(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        view.setLayoutParams(params);
        view.setId(R.id.container);

        setContentView(view);

    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment, "TEST")
                .commit();
    }

}
