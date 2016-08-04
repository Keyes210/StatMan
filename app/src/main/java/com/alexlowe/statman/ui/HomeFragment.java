package com.alexlowe.statman.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.alexlowe.statman.R;
import com.alexlowe.statman.model.Player;
import com.alexlowe.statman.utilities.StatSaver;

import java.util.ArrayList;

/**
 * Created by Keyes on 8/4/2016.
 */
public class HomeFragment extends Fragment{
    private ArrayList<Player> mPlayerList;
    private PlayerAdapter mAdapter;

    private DrawerLayout mDrawerLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mPlayerList = StatSaver.pullData(getActivity());

        mAdapter = new PlayerAdapter(getActivity(), mPlayerList);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        setUpTitleBar();

        return view;
    }


    private void setUpTitleBar(){
       /* View.OnClickListener listener = SortListener.setUpListener(mPlayerList, mAdapter);

        TextView g = (TextView) findViewById(R.id.G);
        g.setOnClickListener(listener);

        TextView a = (TextView) findViewById(R.id.A);
        a.setOnClickListener(listener);

        TextView p = (TextView) findViewById(R.id.P);
        p.setOnClickListener(listener);

        TextView s1 = (TextView) findViewById(R.id.S1);
        s1.setOnClickListener(listener);

        TextView s2 = (TextView) findViewById(R.id.S2);
        s2.setOnClickListener(listener);

        TextView s3 = (TextView) findViewById(R.id.S3);
        s3.setOnClickListener(listener);*/
    }


    @Override
    public void onPause() {
        super.onPause();

        StatSaver.saveStats(getActivity());
    }

}
