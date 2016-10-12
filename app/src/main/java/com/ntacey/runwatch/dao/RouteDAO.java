package com.ntacey.runwatch.dao;

import com.ntacey.runwatch.models.Route;

import java.util.List;

/**
 * Created by PC on 9/28/2016.
 */

public interface RouteDAO {

    public List<Route> getRoutes();

    public void addRoute(Route route);

    //may need update and delete down the road.. not adding those until needed
}
