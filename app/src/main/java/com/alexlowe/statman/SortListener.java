package com.alexlowe.statman;

import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dell on 12/9/2015.
 */
public class SortListener {
    boolean sorted = false;

    public View.OnClickListener setUpListener(final ArrayList<Player> players, final PlayerAdapter adapter) {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sortby = "";
                switch (v.getId()) {
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
                    default:
                        break;
                }

                sortWork(players, sortby, adapter);

            }
        };

        return listener;
    }


    private void sortWork(ArrayList<Player> playerList, final String sortby, PlayerAdapter adapter){
        if(sorted) {
            Collections.sort(playerList, new Comparator<Player>() {
                public int compare(Player player1, Player player2) {
                    return sortKind(player2, sortby).compareTo(sortKind(player1, sortby));
                }
            });
            sorted = false;
        }else{
            Collections.sort(playerList, new Comparator<Player>() {
                public int compare(Player player1, Player player2) {
                    return sortKind(player1, sortby).compareTo(sortKind(player2, sortby));
                }
            });
            sorted = true;
        }
        adapter.notifyDataSetChanged();
    }


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
            default:
                break;
        }

        return result;
    }
}
