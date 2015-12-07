package com.alexlowe.statman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Player> playerList;
    private ListView mListView;
    private PlayerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerList = new ArrayList<Player>();
        playerList.add(Player.players[0]);
        playerList.add(Player.players[1]);
        playerList.add(Player.players[2]);
        playerList.add(Player.players[3]);

        Player.players[0].setThirdStar(3);

        mAdapter = new PlayerAdapter(this, playerList);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);


    }


    
}
