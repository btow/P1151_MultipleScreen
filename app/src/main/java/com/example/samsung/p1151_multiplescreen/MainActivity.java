package com.example.samsung.p1151_multiplescreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import static com.example.samsung.p1151_multiplescreen.TitlesFragment.onItemClickListener;

public class MainActivity extends FragmentActivity implements onItemClickListener {

    private int position = 0;
    private boolean withDetails = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
        withDetails = (findViewById(R.id.cont) != null);

        if (withDetails) {
            showDetails(position);
        }
    }

    private void showDetails(int position) {

        if (withDetails) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.cont);
            if (detailsFragment == null || detailsFragment.getPosition() != position) {
                detailsFragment = DetailsFragment.newInstance(position);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cont, detailsFragment).commit();
            }
        } else {
            startActivity(new Intent(this, DetailsActivity.class).putExtra("position", position));
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
