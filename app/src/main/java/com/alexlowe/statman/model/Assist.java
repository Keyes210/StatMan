package com.alexlowe.statman.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Keyes on 7/31/2016.
 */
public class Assist {
    private String assitId;
    private String scorerId;

    private UUID goalId;
    private UUID assistId;

    private boolean powerPlay = false;
    private boolean shortHanded = false;
    private boolean emptyNet = false;
    private boolean breakAway = false;
    private boolean tieUp = false;
    private boolean penaltyShot = false;
    private boolean overTime = false;

    private int period;
    private Date date;

    public Assist(Goal goal){
        this.goalId = goal.getGoalId();
        assistId = UUID.randomUUID();
        this.date = goal.getDate();
    }


}
