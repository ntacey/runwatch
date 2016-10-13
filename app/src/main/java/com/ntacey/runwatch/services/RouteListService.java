package com.ntacey.runwatch.services;

import com.ntacey.runwatch.dao.RunDAOImpl;
import com.ntacey.runwatch.models.Route;
import com.ntacey.runwatch.models.Run;

import java.util.List;

/**
 * Created by Nick on 10/12/2016.
 */

public class RouteListService {

    private RunDAOImpl rundao = new RunDAOImpl();

    /*
     * A check to see if the route has at least one run. A route with out a run means the route
     * was never fully completed and/or saved.
     *
     */
    public Boolean routeHasRun(Route route) {
        List<Run> runList = rundao.getRuns();
        for (Run run : runList) {
            if (run.getRoute() == route) {
                return true;
            }
        }
        return false;
    }
}
