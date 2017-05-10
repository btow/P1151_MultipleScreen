package com.example.samsung.p1151_multiplescreen;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.samsung.p1151_multiplescreen.TitlesFragment.*;

public class MainActivity extends FragmentActivity implements onItemClickListener {

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
        showDetails(position);
    }

    private void showDetails(int position) {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.cont);
        if (detailsFragment == null || detailsFragment.getPosition() != position) {
            detailsFragment = DetailsFragment.newInstance(position);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.cont, detailsFragment).commit();
        }
    }

    @Override
    public void itemClick(int position) {
        this.position = position;
        showDetails(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", position);
    }
}
