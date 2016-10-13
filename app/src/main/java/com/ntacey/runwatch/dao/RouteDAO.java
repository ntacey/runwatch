package com.ntacey.runwatch.dao;

import com.ntacey.runwatch.models.Route;

import java.util.List;

/**
 * Created by Nick on 9/28/2016.
 */

public interface RouteDAO {

    List<Route> getRoutes();

    void addRoute(Route route);

    //may need update and delete methods later on.. not adding those until needed
}
