package com.alexlowe.statman;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    private ArrayList<Player> playerList;
    private ListView mListView;
    private PlayerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerList = pullData();

        mAdapter = new PlayerAdapter(this, playerList);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);


    }

    private ArrayList<Player> pullData(){
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);
        ArrayList<Player> list = new ArrayList<>();

        if(sp.contains("alex") && sp.contains("mario") && sp.contains("mike") && sp.contains("pat")){
            Player.players[0] = retrieveSaved("alex", sp);
            Player.players[1] = retrieveSaved("mario", sp);
            Player.players[2] = retrieveSaved("mike", sp);
            Player.players[3] = retrieveSaved("pat", sp);

            Log.i("rimjob", "Old Data");

        }else{
            Log.i("rimjob", "New Data");
        }

        list.add(Player.players[0]);
        list.add(Player.players[1]);
        list.add(Player.players[2]);
        list.add(Player.players[3]);

        return list;
    }

    private Player retrieveSaved(String name, SharedPreferences sp){
        Gson gson = new Gson();

        String playerStr = sp.getString(name, "No data");

        return gson.fromJson(playerStr, Player.class);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Gson gson = new Gson();
        String alex = gson.toJson(Player.players[0]);
        String mario = gson.toJson(Player.players[1]);
        String mike = gson.toJson(Player.players[2]);
        String pat = gson.toJson(Player.players[3]);

        SharedPreferences savedStats = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = savedStats.edit();
        editor.putString("alex", alex);
        editor.putString("mario", mario);
        editor.putString("mike", mike);
        editor.putString("pat", pat);
        editor.apply();


        Toast.makeText(this, "Stats Saved!", Toast.LENGTH_SHORT).show();
    }
}
