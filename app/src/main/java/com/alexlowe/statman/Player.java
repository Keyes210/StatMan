package com.alexlowe.statman;

/**
 * Created by dell on 12/6/2015.
 */
public class Player {
    private String name;
    private int imgID;
    private int goals;
    private int assists;
    private int points;
    private int firstStar;
    private int secondStar;
    private int thirdStar;

    public static final Player[] players = {
            new Player("Lowe", R.drawable.me),
            new Player("Mario", R.drawable.mario),
            new Player("Mike", R.drawable.mike),
            new Player("Pat", R.drawable.pat),
    };

    public Player(String name, int resourceID) {
        this.name = name;
        this.imgID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFirstStar() {
        return firstStar;
    }

    public void setFirstStar(int firstStar) {
        this.firstStar = firstStar;
    }

    public int getSecondStar() {
        return secondStar;
    }

    public void setSecondStar(int secondStar) {
        this.secondStar = secondStar;
    }

    public int getThirdStar() {
        return thirdStar;
    }

    public void setThirdStar(int thirdStar) {
        this.thirdStar = thirdStar;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
