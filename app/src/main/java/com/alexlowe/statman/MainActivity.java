package com.alexlowe.statman;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity{
    public static final String PREFS_NAME = "MyPrefsFile";

    private ArrayList<Player> playerList;
    private ListView mListView;
    private PlayerAdapter mAdapter;
    private TextView g ,a ,p ,s1 , s2, s3;
    private boolean sorted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerList = pullData();

        mAdapter = new PlayerAdapter(this, playerList);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);

        g = (TextView)findViewById(R.id.G);
        g.setOnClickListener(listener);
        a = (TextView)findViewById(R.id.A);
        a.setOnClickListener(listener);
        p = (TextView)findViewById(R.id.P);
        p.setOnClickListener(listener);
        s1 = (TextView)findViewById(R.id.S1);
        s1.setOnClickListener(listener);
        s2 = (TextView)findViewById(R.id.S2);
        s2.setOnClickListener(listener);
        s3 = (TextView)findViewById(R.id.S3);
        s3.setOnClickListener(listener);

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

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String sortby = "";
            switch (v.getId()){
                case R.id.G:
                    sortby = "g";
                    break;
                case R.id.A:
                    sortby = "a";
                    break;
                case R.id.P:
                    sortby = "p";
                    break;
                case R.id.S1:
                    sortby = "1";
                    break;
                case R.id.S2:
                    sortby = "2";
                    break;
                case R.id.S3:
                    sortby = "3";
                    break;
            }

            final String finalSortby = sortby;
            if(sorted) {
                Collections.sort(playerList, new Comparator<Player>() {
                    public int compare(Player player1, Player player2) {
                        return sortKind(player2, finalSortby).compareTo(sortKind(player1, finalSortby));
                    }
                });
                sorted = false;
            }else{
                Collections.sort(playerList, new Comparator<Player>() {
                    public int compare(Player player1, Player player2) {
                        return sortKind(player1, finalSortby).compareTo(sortKind(player2, finalSortby));
                    }
                });
                sorted = true;
            }
            mAdapter.notifyDataSetChanged();
        }
    };

    private Integer sortKind(Player player, String sortby) {
        int result = 0;
        switch (sortby){
            case "g":
                result = player.getGoals();
                break;
            case "a":
                result = player.getAssists();
                break;
            case "p":
                result = player.getPoints();
                break;
            case "1":
                result = player.getFirstStar();
                break;
            case "2":
                result = player.getSecondStar();
                break;
            case "3":
                result = player.getThirdStar();
                break;
        }

        return result;
    }



}
