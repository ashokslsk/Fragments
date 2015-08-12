package com.ashokslsk.flexibleui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ashu on 12/08/15.
 */
public class FragmentB extends Fragment {

    TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        text = (TextView) view.findViewById(R.id.textView);
        return view;
    }


    public void changeData(int index){
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        text.setText(descriptions[index]);
    }
}
