package com.ntacey.runwatch.components;

import android.widget.TextView;

import com.ntacey.runwatch.services.NewRouteService;

/**
 * Created by Nick on 10/15/2016.
 */

public class RunTimer {
    private TextView timerView; //TextView that will be incremented
    private NewRouteService nrs; //To help format
    private int secs = 0;
    private int mins = 0;
    private int hours = 0;

    public RunTimer(TextView timerView, NewRouteService nrs) {
        this.timerView = timerView;
        this.nrs = nrs;
    }

    /*
     * Method calculates the time: increments secs, mins, and hours based on values.
     * Currently relies on a timer from activity class to tick time.
     */
    public void startTimer() {
        timerView.setText(getTime());
        secs++;

        if (secs == 60) {
            mins++;
            secs = 0;

            if (mins == 60) {
                hours++;
                mins = 0;
            }
        }
    }

    //format time in MM:SS format
    private String formatMins() {
        return nrs.formatIntToString(mins) + ":" + nrs.formatIntToString(secs);
    }

    //format time in HH:MM:SS format
    private String formatHours() {
        return nrs.formatIntToString(hours) + ":" + nrs.formatIntToString(mins)
                + ":" + nrs.formatIntToString(secs);
    }

    // returns a capture of the current time
    public String getTime() {
        if(hours == 0) {
            return formatMins();
        } else {
            return formatHours();
        }
    }
}
