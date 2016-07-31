package com.alexlowe.statman;

/**
 * Created by Keyes on 4/12/2016.
 */
public class Goal {
    private Player scorer;
    private Player assist;
    private boolean powerPlay;
    private boolean shortHanded;

    public Goal(Player scorer){
        this.scorer = scorer;
    }

    public Player getScorer() {
        return scorer;
    }

    public void setScorer(Player scorer) {
        this.scorer = scorer;
    }

    public Player getAssist() {
        return assist;
    }

    public void setAssist(Player assist) {
        this.assist = assist;
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
}
