package com.alexlowe.statman;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dell on 12/9/2015.
 */
public class ViewMaster {

   /* public static void setUpTouchResponse(final Context context, final TextView tv, final Player player, final String statKey) {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(context, tv, player, statKey);
            }
        });
    }

    public static void setUpTouchResponse(final Context context, final TextView tv, final TextView tv2, final Player player, final String statKey) {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(context, tv, tv2, player, statKey);
            }
        });
    }


    private static void show(Context context, final TextView tv, final Player player, final String statKey) {
        final Dialog d = new Dialog(context);
        d.setTitle("Change Value");
        d.setContentView(R.layout.dialog);

        Button plus = (Button) d.findViewById(R.id.plusButton);
        Button minus = (Button) d.findViewById(R.id.minusButton);
        Button ok = (Button) d.findViewById(R.id.okButton);
        final TextView[] dialogET = {(TextView) d.findViewById(R.id.dialogET)};
        dialogET[0].setText(tv.getText());
        final int[] value = {Integer.valueOf(tv.getText().toString())};

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value[0]++;
                dialogET[0].setText(value[0] + "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value[0] -= 1;
                dialogET[0].setText(value[0] + "");
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(dialogET[0].getText());
                d.dismiss();
                updateData(dialogET[0].getText().toString(), player, statKey);
            }
        });

        d.show();

    }

    private static void show(Context context, final TextView tv, final TextView tv2, final Player player, final String statKey) {
        final Dialog d = new Dialog(context);
        d.setTitle("Change Value");
        d.setContentView(R.layout.dialog);

        Button plus = (Button) d.findViewById(R.id.plusButton);
        Button minus = (Button) d.findViewById(R.id.minusButton);
        Button ok = (Button) d.findViewById(R.id.okButton);
        final TextView[] dialogET = {(TextView) d.findViewById(R.id.dialogET)};
        dialogET[0].setText(tv.getText());
        final int[] value = {Integer.valueOf(tv.getText().toString())};

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value[0]++;
                dialogET[0].setText(value[0] + "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value[0] -= 1;
                dialogET[0].setText(value[0] + "");
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(dialogET[0].getText());
                d.dismiss();
                updateData(dialogET[0].getText().toString(), player, statKey);
                tv2.setText(String.valueOf(player.getGoals() + player.getAssists()));
                updateData(String.valueOf(player.getGoals() + player.getAssists()), player, "p");
            }
        });

        d.show();

    }


    private static void updateData(String value, Player player, String statKey) {
        switch (statKey) {
            case "g":
                player.setGoals(Integer.valueOf(value));
                break;
            case "a":
                player.setAssists(Integer.valueOf(value));
                break;
            case "p":
                player.setPoints(Integer.valueOf(value));
                break;
            case "1":
                player.setFirstStar(Integer.valueOf(value));
                break;
            case "2":
                player.setSecondStar(Integer.valueOf(value));
                break;
            case "3":
                player.setThirdStar(Integer.valueOf(value));
                break;

        }
    }*/
}
