package com.ashokslsk.flexibleui;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.Communicator {

    FragmentA fragment1;
    FragmentB fragment2;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        fragment1 = (FragmentA) manager.findFragmentById(R.id.fragment);

        fragment1.setComm(this);
    }

    @Override
    public void respond(int index) {

        fragment2 = (FragmentB) manager.findFragmentById(R.id.fragment2);
        if(fragment2 != null && fragment2.isVisible() ){
            // Landscape view
            fragment2.changeData(index);

        }else {
            //Portrait view
            Intent i = new Intent(MainActivity.this, AnotherActivity.class);
            i.putExtra("index", index);
            startActivity(i);
        }

    }
}
