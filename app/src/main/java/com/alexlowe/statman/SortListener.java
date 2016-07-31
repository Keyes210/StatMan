package com.alexlowe.statman;

import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dell on 12/9/2015.
 */
public class SortListener {
   /* static boolean sorted = false;

    public static View.OnClickListener setUpListener(final ArrayList<Player> players, final PlayerAdapter adapter) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sortBy = "";
                switch (v.getId()) {
                    case R.id.G:
                        sortBy = "g";
                        break;
                    case R.id.A:
                        sortBy = "a";
                        break;
                    case R.id.P:
                        sortBy = "p";
                        break;
                    case R.id.S1:
                        sortBy = "1";
                        break;
                    case R.id.S2:
                        sortBy = "2";
                        break;
                    case R.id.S3:
                        sortBy = "3";
                        break;
                    default:
                        break;
                }

                sortWork(players, sortBy, adapter);

            }
        };
    }


    private static void sortWork(ArrayList<Player> playerList, final String sortby, PlayerAdapter adapter){
            if (sorted) {
                Collections.sort(playerList, new Comparator<Player>() {
                    public int compare(Player player1, Player player2) {
                        return sortKind(player2, sortby).compareTo(sortKind(player1, sortby));
                    }
                });
                sorted = false;
            } else {
                Collections.sort(playerList, new Comparator<Player>() {
                    public int compare(Player player1, Player player2) {
                        return sortKind(player1, sortby).compareTo(sortKind(player2, sortby));
                    }
                });
                sorted = true;
            }

        adapter.notifyDataSetChanged();
    }


    private static Integer sortKind(Player player, String sortby) {
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

*/
}
