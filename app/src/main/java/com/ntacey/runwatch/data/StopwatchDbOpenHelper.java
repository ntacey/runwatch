package com.ntacey.runwatch.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nick on 9/27/2016.
 *
 * Application db setup class
 */

public class StopwatchDbOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "stopwatch";
    private static final String CREATE_ROUTES_TABLE = "CREATE TABLE routes (id integer, name text)";
    private static final String CREATE_TIMES_TABLE = "" +
            "CREATE TABLE times (id integer, routeId integer, isFinal integer, checkpoint int," +
            "time text)";

    public StopwatchDbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    //create tables here
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("creating tables");
        db.execSQL(CREATE_ROUTES_TABLE);
        db.execSQL(CREATE_TIMES_TABLE);
    }
}
