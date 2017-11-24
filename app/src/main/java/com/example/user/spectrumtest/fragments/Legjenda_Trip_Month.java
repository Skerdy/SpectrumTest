package com.example.user.spectrumtest.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.spectrumtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 11/22/2017.
 */

public class Legjenda_Trip_Month extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView lv = (ListView) inflater.inflate(R.layout.activity_main, container, false);

        return lv;
    }

}







