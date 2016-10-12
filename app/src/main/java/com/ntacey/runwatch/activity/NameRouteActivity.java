package com.ntacey.runwatch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ntacey.runwatch.R;
import com.ntacey.runwatch.dao.RouteDAOImpl;
import com.ntacey.runwatch.models.Route;

import java.util.Date;
import java.util.UUID;

public class NameRouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameroute);

        Button tButton = (Button)findViewById(R.id.button);
        final EditText tEditText = (EditText)findViewById(R.id.editText);

        tButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        String sEditText = tEditText.toString();

                        saveRouteName(sEditText);

                        Intent i = new Intent(view.getContext(), NewRouteActivity.class);
                        startActivity(i);
                    }
                }
        );
    }

    private void saveRouteName(String routeName) {
        //TODO add a check to make sure name doesn't already exist in db
        Route newRoute = new Route();
        UUID id = UUID.randomUUID();
        Date timestamp = new Date();
        RouteDAOImpl rdi = new RouteDAOImpl();

        newRoute.setId(id.toString());
        newRoute.setName(routeName);
        newRoute.setDateCreated(timestamp);

        rdi.addRoute(newRoute);
    }
}
