package com.alexlowe.statman;

import java.util.Date;

/**
 * Created by dell on 12/9/2015.
 */
public class Game {
    private int homeScore;
    private int awayScore;
    private boolean overtime = false;
    private char result;
    private Date gameDate;

    private int[] alexStat;
    private int[] marioStat;
    private int[] mikeStat;
    private int[] patStat;

    public Game (Date date, int home, int away, boolean overtime){
        this.gameDate = date;
        this.homeScore = home;
        this.awayScore = away;
        this.overtime = overtime;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public boolean isOvertime() {
        return overtime;
    }

    public void setOvertime(boolean overtime) {
        this.overtime = overtime;
    }

    public char getResult() {
        char outcome;

        if(awayScore > homeScore){
            outcome = 'l';
        }else if(overtime){
            outcome = 'o';
        }else{
            outcome = 'w';
        }

        result = outcome;
        return result;
    }


    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public int[] getAlexStat() {
        return alexStat;
    }

    public void setAlexStat(int[] alexStat) {
        this.alexStat = alexStat;
    }

    public int[] getMarioStat() {
        return marioStat;
    }

    public void setMarioStat(int[] marioStat) {
        this.marioStat = marioStat;
    }

    public int[] getMikeStat() {
        return mikeStat;
    }

    public void setMikeStat(int[] mikeStat) {
        this.mikeStat = mikeStat;
    }

    public int[] getPatStat() {
        return patStat;
    }

    public void setPatStat(int[] patStat) {
        this.patStat = patStat;
    }
}
