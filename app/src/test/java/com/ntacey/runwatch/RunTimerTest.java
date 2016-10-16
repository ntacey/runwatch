package com.ntacey.runwatch;

import android.widget.TextView;

import com.ntacey.runwatch.components.RunTimer;
import com.ntacey.runwatch.services.NewRouteService;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by PC on 10/15/2016.
 */

public class RunTimerTest {
    TextView timerView = null;
    private NewRouteService nrs = new NewRouteService();

    @Test
    public void StartTimerSecondPositiveTest() {
        final RunTimer runTimer = new RunTimer(timerView, nrs);
        //increment timer by 37 seconds
        startTimerBySecondAmount(runTimer, 37);
        assertEquals(runTimer.getTime(), "00:37");
    }

    @Test
    public void StartTimerSecondNegativeTest() {
        final RunTimer runTimer = new RunTimer(timerView, nrs);
        //increment timer by 37 seconds
        startTimerBySecondAmount(runTimer, 37);
        assertNotEquals(runTimer.getTime(), "00:00");
    }

    @Test
    public void StartTimerMinutePositiveTest() {
        final RunTimer runTimer = new RunTimer(timerView, nrs);
        //increment timer by 90 seconds
        startTimerBySecondAmount(runTimer, 90);
        assertEquals(runTimer.getTime(), "01:30");
    }

    @Test
    public void StartTimerMinuteNegativeTest() {
        final RunTimer runTimer = new RunTimer(timerView, nrs);
        //increment timer by 90 seconds
        startTimerBySecondAmount(runTimer, 90);
        assertNotEquals(runTimer.getTime(), "00:90");
    }

    @Test
    public void StartTimerHourPositiveTest() {
        final RunTimer runTimer = new RunTimer(timerView, nrs);
        //increment timer by 90 seconds
        startTimerBySecondAmount(runTimer, 3930);
        assertEquals(runTimer.getTime(), "01:05:30");
    }

    @Test
    public void StartTimerHourNegativeTest() {
        final RunTimer runTimer = new RunTimer(timerView, nrs);
        //increment timer by 90 seconds
        startTimerBySecondAmount(runTimer, 3930);
        assertNotEquals(runTimer.getTime(), "00:65:30");
    }

    // increment timer by input second amount
    private void startTimerBySecondAmount(RunTimer runTimer, int seconds) {
        for (int i = 0; i == seconds; i++) {
            runTimer.startTimer();
        }
    }
}
