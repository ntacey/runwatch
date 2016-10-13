package com.ntacey.runwatch.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ntacey.runwatch.R;
import com.ntacey.runwatch.dao.RouteDAOImpl;
import com.ntacey.runwatch.models.Route;

import java.util.ArrayList;

/**
 * Created by Nick on 9/26/2016.
 */

public class RouteListActivity extends AppCompatActivity {
    private static RouteListActivity instance;

    public RouteListActivity(){
        instance = this;
    }
    public static Context getContext() {
        return instance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routelist);

        RouteDAOImpl rdi = new RouteDAOImpl();
        ArrayList<Route> routes = new ArrayList<>(rdi.getRoutes()); //list of routes stored in realm

        if (routes != null && !routes.isEmpty()) {

        } else {
            String noRoutesMessage = "no routes found";
        }
    }

    // on user clicking add new route, go to namerouteacitivity
    public void addNewRoute(View view) {
        Intent i = new Intent(this, NameRouteActivity.class);
        startActivity(i);
    }

}
