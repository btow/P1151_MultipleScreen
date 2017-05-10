package com.example.samsung.p1151_multiplescreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public static DetailsFragment newInstance(int pos) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("position", pos);
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

    int getPosition() {
        return getArguments().getInt("position", 0);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details, container, false);
        TextView tvText = (TextView) view.findViewById(R.id.tvText);
        tvText.setText(getResources().getStringArray(R.array.content)[getPosition()]);
        return view;
    }

}
