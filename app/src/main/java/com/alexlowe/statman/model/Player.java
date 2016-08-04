package com.alexlowe.statman.model;


import com.alexlowe.statman.R;

/**
 * Created by dell on 12/6/2015.
 */
public class Player {
    private String mName;
    private int mImageId;

    public static final Player[] players = {
            new Player("lowe", R.drawable.me),
            new Player("mario", R.drawable.mario),
            new Player("mike", R.drawable.mike),
            new Player("pat", R.drawable.pat),
    };

    public Player(String name, int resourceId){
        mName = name;
        mImageId = resourceId;
    }

    public String getId() {
        return mName;
    }

    public int getImageId() {
        return mImageId;
    }
}
