package com.alexlowe.statman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 12/6/2015.
 */
public class PlayerAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> mPlayers;

    public PlayerAdapter(Context context, ArrayList<Player> list) {
        super(context, 0, list);
        this.mPlayers = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = mPlayers.get(position);


        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_card, parent, false);

            viewHolder.icon = (ImageView) convertView.findViewById(R.id.playerImage);
            viewHolder.goals = (TextView) convertView.findViewById(R.id.goalET);
            viewHolder.assists = (TextView) convertView.findViewById(R.id.assistET);
            viewHolder.points = (TextView) convertView.findViewById(R.id.pointsET);
            viewHolder.star1 = (TextView) convertView.findViewById(R.id.star1ET);
            viewHolder.star2 = (TextView) convertView.findViewById(R.id.star2ET);
            viewHolder.star3 = (TextView) convertView.findViewById(R.id.star3ET);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageBitmap(ImageHelper.decodeSampleBitmapFromResource(getContext()
                .getResources(), player.getImgID(), 50, 50));
        viewHolder.goals.setText(String.valueOf(player.getGoals()));
        viewHolder.assists.setText(String.valueOf(player.getAssists()));
        viewHolder.points.setText(String.valueOf(player.getGoals() + player.getAssists()));
        viewHolder.star1.setText(String.valueOf(player.getFirstStar()));
        viewHolder.star2.setText(String.valueOf(player.getSecondStar()));
        viewHolder.star3.setText(String.valueOf(player.getThirdStar()));

        ViewMaster.setUpTouchResponse(getContext(), viewHolder.goals, viewHolder.points, player, "g");
        ViewMaster.setUpTouchResponse(getContext(), viewHolder.assists, viewHolder.points, player, "a");
        ViewMaster.setUpTouchResponse(getContext(), viewHolder.star1, player, "1");
        ViewMaster.setUpTouchResponse(getContext(), viewHolder.star2, player, "2");
        ViewMaster.setUpTouchResponse(getContext(), viewHolder.star3, player, "3");

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


}
