package com.ntacey.runwatch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ntacey.runwatch.R;
import com.ntacey.runwatch.services.NewRouteService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nick on 9/29/2016.
 */

public class NewRouteActivity extends AppCompatActivity {
    private NewRouteService nrs = new NewRouteService();
    private int secs = 0;
    private int mins = 0;
    private int hours = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newroute);

        Button checkpointButton = (Button)findViewById(R.id.button);
        Button completeButton = (Button)findViewById(R.id.button2);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView timerView = (TextView) findViewById(R.id.textView);

                        if(hours == 0) {
                            timerView.setText(nrs.formatIntToString(mins) + ":" + nrs.formatIntToString(secs));
                        } else {
                            timerView.setText(nrs.formatIntToString(hours) + ":" + nrs.formatIntToString(mins)
                                + ":" + nrs.formatIntToString(secs));
                        }
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
                });
            }
        }, 0, 1000);

        checkpointButton.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View view) {
                    Log.i("time test", "time: " + mins + ":" + secs);
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
