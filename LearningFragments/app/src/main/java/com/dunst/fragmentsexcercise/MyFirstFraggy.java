package com.dunst.fragmentsexcercise;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ashu on 04/07/15.
 */
public class MyFirstFraggy extends Fragment {

    public String LOG_TAG ="frag";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG,"onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG,"onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_attachable_to_activty,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(LOG_TAG,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(LOG_TAG,"OnStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(LOG_TAG,"onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(LOG_TAG,"onPause");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(LOG_TAG,"onSavedInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Log.d(LOG_TAG,"onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(LOG_TAG,"onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(LOG_TAG,"onDetach");
        super.onDetach();
    }
}
