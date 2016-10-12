package com.ntacey.runwatch.models;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by PC on 9/28/2016.
 */

@RealmClass
public class Times implements RealmModel {

    @PrimaryKey
    private int id;

    private int checkpoint; //holds the order of the checkpoint. so 1 - x as an int

    private String time; //time checkpoint is hit

    private Run run; //which run this checkpoint time belongs too, which belongs to a route

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }
}
