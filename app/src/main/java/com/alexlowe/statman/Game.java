package com.alexlowe.statman;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dell on 12/9/2015.
 */
public class Game {
    private int homeScore;
    private int awayScore;
    private boolean overtime = false;
    private char result;
    private String name;
    private Date gameDate;
    private Player firstStar;
    private Player secondStar;
    private Player thirdStar;

    private ArrayList<Goal> goalList;

    public Game (Date date){
        this.gameDate = date;
        this.name = ""; //formatted version of date will go here.
        goalList = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getFirstStar() {
        return firstStar;
    }

    public void setFirstStar(Player firstStar) {
        this.firstStar = firstStar;
    }

    public Player getSecondStar() {
        return secondStar;
    }

    public void setSecondStar(Player secondStar) {
        this.secondStar = secondStar;
    }

    public Player getThirdStar() {
        return thirdStar;
    }

    public void setThirdStar(Player thirdStar) {
        this.thirdStar = thirdStar;
    }

    public ArrayList<Goal> getGoalList() {
        return goalList;
    }

    public void setGoalList(ArrayList<Goal> goalList) {
        this.goalList = goalList;
    }
}
