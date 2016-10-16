package com.ntacey.runwatch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ntacey.runwatch.R;
import com.ntacey.runwatch.components.RunTimer;
import com.ntacey.runwatch.services.NewRouteService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nick on 9/29/2016.
 */

public class NewRouteActivity extends AppCompatActivity {
    private NewRouteService nrs = new NewRouteService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newroute);

        Button checkpointButton = (Button)findViewById(R.id.button);
        Button completeButton = (Button)findViewById(R.id.button2);
        TextView timerView = (TextView) findViewById(R.id.textView);
        final RunTimer runTimer = new RunTimer(timerView, nrs);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        runTimer.startTimer();
                    }
                });
            }
        }, 0, 1000); // tick every 1 second

        /*
         * When Checkpoint is pressed, capture the current time on runtimer and display it in
         * list, as well as save it.
         */
        checkpointButton.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View view) {
                    Log.i("time test", runTimer.getTime());
                }
            }
        );

        completeButton.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View view) {

                }
            }
        );
    }
}
