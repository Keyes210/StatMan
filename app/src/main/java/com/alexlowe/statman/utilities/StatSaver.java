package com.alexlowe.statman.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.alexlowe.statman.model.Player;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dell on 12/9/2015.
 */
public class StatSaver {
    public static final String PREFS_NAME = "MyPrefsFile";

    public static void saveStats(Context context){
        Gson gson = new Gson();
        String alex = gson.toJson(Player.players[0]);
        String mario = gson.toJson(Player.players[1]);
        String mike = gson.toJson(Player.players[2]);
        String pat = gson.toJson(Player.players[3]);

        SharedPreferences savedStats = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = savedStats.edit();
        editor.putString("alex", alex);
        editor.putString("mario", mario);
        editor.putString("mike", mike);
        editor.putString("pat", pat);
        editor.apply();

        Toast.makeText(context, "Stats Saved!", Toast.LENGTH_SHORT).show();
    }

    public static ArrayList<Player> pullData(Context context){
        SharedPreferences sp = context.getSharedPreferences(PREFS_NAME, 0);
        ArrayList<Player> list = new ArrayList<>();

        if(sp.contains("alex") && sp.contains("mario") && sp.contains("mike") && sp.contains("pat")){
            Player.players[0] = retrieveSaved("alex", sp);
            Player.players[1] = retrieveSaved("mario", sp);
            Player.players[2] = retrieveSaved("mike", sp);
            Player.players[3] = retrieveSaved("pat", sp);

        }

        list.add(Player.players[0]);
        list.add(Player.players[1]);
        list.add(Player.players[2]);
        list.add(Player.players[3]);

        return list;
    }

    private static Player retrieveSaved(String name, SharedPreferences sp){
        Gson gson = new Gson();

        String playerStr = sp.getString(name, "No data");

        return gson.fromJson(playerStr, Player.class);
    }
}
