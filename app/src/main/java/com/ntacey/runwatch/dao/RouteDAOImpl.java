package com.ntacey.runwatch.dao;

import android.util.Log;

import com.ntacey.runwatch.models.Route;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by PC on 9/28/2016.
 */

public class RouteDAOImpl implements RouteDAO {

    private Realm realm = Realm.getDefaultInstance();

    @Override
    public List<Route> getRoutes(){
        // return all routes, ordered by the date they where created
        RealmResults<Route> query = realm.where(Route.class).findAll().sort("dateCreated", Sort.ASCENDING);
        List<Route> routes = query;
        return routes;
    }

    @Override
    public void addRoute(Route route){
        realm.beginTransaction();
        realm.copyToRealm(route);
        realm.commitTransaction();

        Log.i(this.getClass().getName(), "new route added. id=" + route.getId() + " name=" +
                route.getName() + " date created=" + route.getDateCreated());
    }

}
