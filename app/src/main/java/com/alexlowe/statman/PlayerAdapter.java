package com.alexlowe.statman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 12/6/2015.
 */
public class PlayerAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> mPlayers;

    public PlayerAdapter(Context context, ArrayList<Player> list){
        super(context, 0, list);
        this.mPlayers = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = mPlayers.get(position);


        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_card, parent, false);

            viewHolder.icon = (ImageView)convertView.findViewById(R.id.playerImage);
            viewHolder.goals = (TextView) convertView.findViewById(R.id.goalET);
            viewHolder.assists = (TextView) convertView.findViewById(R.id.assistET);
            viewHolder.points = (TextView) convertView.findViewById(R.id.pointsET);
            viewHolder.star1 = (TextView) convertView.findViewById(R.id.star1ET);
            viewHolder.star2 = (TextView) convertView.findViewById(R.id.star2ET);
            viewHolder.star3 = (TextView) convertView.findViewById(R.id.star3ET);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageBitmap(decodeSampleBitmapFromResource(getContext()
                .getResources(), player.getImgID(), 50, 50));
        viewHolder.goals.setText(String.valueOf(player.getGoals()));
        viewHolder.assists.setText(String.valueOf(player.getAssists()));
        viewHolder.points.setText(String.valueOf(player.getGoals() + player.getAssists()));
        viewHolder.star1.setText(String.valueOf(player.getFirstStar()));
        viewHolder.star2.setText(String.valueOf(player.getSecondStar()));
        viewHolder.star3.setText(String.valueOf(player.getThirdStar()));

        setUpTouchResponse(viewHolder.goals, viewHolder.points, player, "g");
        setUpTouchResponse(viewHolder.assists, viewHolder.points, player, "a");
        setUpTouchResponse(viewHolder.star1, player, "1");
        setUpTouchResponse(viewHolder.star2, player, "2");
        setUpTouchResponse(viewHolder.star3, player, "3");

        return convertView;
    }



    static class ViewHolder {
        TextView goals;
        TextView assists;
        TextView points;
        TextView star1;
        TextView star2;
        TextView star3;
        ImageView icon;
    }


    private void setUpTouchResponse(final TextView tv, final Player player, final String statKey){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(tv, player, statKey);
            }
        });
    }

    private void setUpTouchResponse(final TextView tv, final TextView tv2, final Player player, final String statKey){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(tv, tv2, player, statKey);
            }
        });
    }


    private void show(final TextView tv, final Player player, final String statKey) {
        final Dialog d = new Dialog(getContext());
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

    private void show(final TextView tv, final TextView tv2, final Player player, final String statKey) {
        final Dialog d = new Dialog(getContext());
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


    private void updateData(String value, Player player, String statKey) {
        switch (statKey){
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
    }



    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }


    public static Bitmap decodeSampleBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
