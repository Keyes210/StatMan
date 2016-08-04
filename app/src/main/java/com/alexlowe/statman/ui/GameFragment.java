package com.alexlowe.statman.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alexlowe.statman.R;
import com.alexlowe.statman.utilities.StatSaver;

/**
 * Created by Keyes on 8/4/2016.
 */
public class GameFragment extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        return view;
    }
}
