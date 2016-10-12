package com.ntacey.runwatch.models;

import java.util.Date;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by PC on 9/28/2016.
 */

@RealmClass
public class Run implements RealmModel {

    @PrimaryKey
    private int id;

    private Date r_date; //run date

    private String time; //total time it took for run

    private Route route;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
