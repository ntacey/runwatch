package com.ntacey.runwatch.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ntacey.runwatch.R;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;

    public MainActivity(){
        instance = this;
    }
    public static Context getContext() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getContext());
    }

    public void gotoRouteList(View view) {
        Intent i = new Intent(this, RouteListActivity.class);
        startActivity(i);
    }
}
