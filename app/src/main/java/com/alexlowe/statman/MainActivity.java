package com.alexlowe.statman;

import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<Player> mPlayerList;
    private PlayerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerList = StatSaver.pullData(this);

        mAdapter = new PlayerAdapter(this, mPlayerList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        setUpTitleBar();


    }


    private void setUpTitleBar(){
        View.OnClickListener listener = SortListener.setUpListener(mPlayerList, mAdapter);

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

        StatSaver.saveStats(this);
    }




}
