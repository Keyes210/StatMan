package com.alexlowe.statman.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Keyes on 4/12/2016.
 */
public class Goal {
    private String scorerId;
    private String assitId;
    private UUID gameId;
    private UUID goalId;

    private boolean powerPlay = false;
    private boolean shortHanded = false;
    private boolean emptyNet = false;
    private boolean breakAway = false;
    private boolean tieUp = false;
    private boolean penaltyShot = false;
    private boolean overTime = false;

    private int period;
    private Date date;

    public Goal(UUID gameId){
        this.gameId = gameId;
        goalId = UUID.randomUUID();
        this.date = new Date();
    }

    public String getScorerId() {
        return scorerId;
    }

    public void setScorerId(String scorerId) {
        this.scorerId = scorerId;
    }

    public String getAssitId() {
        return assitId;
    }

    public void setAssitId(String assitId) {
        this.assitId = assitId;
    }

    public boolean isPowerPlay() {
        return powerPlay;
    }

    public void setPowerPlay(boolean powerPlay) {
        this.powerPlay = powerPlay;
    }

    public boolean isShortHanded() {
        return shortHanded;
    }

    public void setShortHanded(boolean shortHanded) {
        this.shortHanded = shortHanded;
    }

    public boolean isEmptyNet() {
        return emptyNet;
    }

    public void setEmptyNet(boolean emptyNet) {
        this.emptyNet = emptyNet;
    }

    public boolean isBreakAway() {
        return breakAway;
    }

    public void setBreakAway(boolean breakAway) {
        this.breakAway = breakAway;
    }

    public boolean isTieUp() {
        return tieUp;
    }

    public void setTieUp(boolean tieUp) {
        this.tieUp = tieUp;
    }

    public boolean isPenaltyShot() {
        return penaltyShot;
    }

    public void setPenaltyShot(boolean penaltyShot) {
        this.penaltyShot = penaltyShot;
    }

    public boolean isOverTime() {
        return overTime;
    }

    public void setOverTime(boolean overTime) {
        this.overTime = overTime;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Date getDate() {
        return date;
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID id){
        this.gameId = id;
    }

    public UUID getGoalId() {
        return goalId;
    }

    public void setGoalId(UUID goalId) {
        this.goalId = goalId;
    }
}
