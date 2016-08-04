package com.alexlowe.statman.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by dell on 12/9/2015.
 */
public class Game {
    private UUID gameId;
    private Date gameDate;

    private String ourTeam;
    private String opponentTeam;

    private int ourScore;
    private int opponentScore;
    private char result;


    private boolean overtime = false;
    private boolean shootout = false;

    private String firstStarID;
    private String secondStarID;
    private String thirdStarID;

    private ArrayList<Goal> goalList;

    public Game (Date date){
        this.gameDate = date;
        this.gameId = UUID.randomUUID();
        goalList = new ArrayList<>();
    }

    public UUID getGameId() {
        return gameId;
    }

    public Date getGameDate() {
        return gameDate;
    }


    public String getOurTeam() {
        return ourTeam;
    }

    public void setOurTeam(String ourTeam) {
        this.ourTeam = ourTeam;
    }

    public String getOpponenTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public int getOurScore() {
        return ourScore;
    }

    public void setOurScore(int ourScore) {
        this.ourScore = ourScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }

    public char getResult() {
        setResult();
        return result;
    }

    public void setResult() {
        char outcome;

        if(opponentScore > ourScore){
            outcome = (overtime) ? 'o' : 'l';
        }else{
            outcome = 'w';
        }

        result = outcome;
    }

    public boolean isOvertime() {
        return overtime;
    }

    public void setOvertime(boolean overtime) {
        this.overtime = overtime;
    }

    public boolean isShootout() {
        return shootout;
    }

    public void setShootout(boolean shootout) {
        this.shootout = shootout;
    }

    public String getFirstStarID() {
        return firstStarID;
    }

    public void setFirstStarID(String firstStarID) {
        this.firstStarID = firstStarID;
    }

    public String getSecondStarID() {
        return secondStarID;
    }

    public void setSecondStarID(String secondStarID) {
        this.secondStarID = secondStarID;
    }

    public String getThirdStarID() {
        return thirdStarID;
    }

    public void setThirdStarID(String thirdStarID) {
        this.thirdStarID = thirdStarID;
    }

    public ArrayList<Goal> getGoalList() {
        return goalList;
    }

    public void addGoal(Goal goal) {
        this.goalList.add(goal);
    }
}
