package com.example.samsung.p1151_multiplescreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by samsung on 10.05.2017.
 */

public class TitlesFragment extends ListFragment {

    public interface onItemClickListener {
        public void itemClick(int position);
    }

    onItemClickListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.headers));
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (onItemClickListener)getActivity();
        Toast.makeText(context, "TitlesFragment onAttach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listener.itemClick(position);
        Toast.makeText(getContext(), "TitlesFragment onListItemClick()", Toast.LENGTH_SHORT).show();
    }
}
