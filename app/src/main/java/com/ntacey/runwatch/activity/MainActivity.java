package com.ntacey.runwatch.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ntacey.runwatch.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private Realm realm;
    private RealmConfiguration config;

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

        /*
         * Realm configuration. Currently schema v2, had to change with change to route model.
         * deleteRealmIfMigrationNeeded is set, meaning any changes to the schema will delete the
         * data on disk.
         */
        try {
            Realm.init(getContext());
            config = new RealmConfiguration.Builder().schemaVersion(2).deleteRealmIfMigrationNeeded().build();
            Realm.setDefaultConfiguration(config);
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "error with realm config: " + e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public void gotoRouteList(View view) {
        Intent i = new Intent(this, RouteListActivity.class);
        startActivity(i);
    }
}
