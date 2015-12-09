package com.alexlowe.statman;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity{
    private ArrayList<Player> mPlayerList;
    private PlayerAdapter mAdapter;
    private SortListener mSortListener = new SortListener();
    private StatSaver mStatSaver = new StatSaver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerList = mStatSaver.pullData(this);

        mAdapter = new PlayerAdapter(this, mPlayerList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        setUpTitleBar();

    }


    private void setUpTitleBar(){
        View.OnClickListener listener = mSortListener.setUpListener(mPlayerList, mAdapter);

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
        s3.setOnClickListener(listener);
    }


    @Override
    protected void onPause() {
        super.onPause();

        mStatSaver.saveStats(this);
    }

}
