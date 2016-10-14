package com.ntacey.runwatch;

import com.ntacey.runwatch.models.Route;
import com.ntacey.runwatch.services.RouteListService;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Nick on 10/13/2016.
 */

public class RouteListServiceTest {

    private RouteListService rls;

    @Before
    public void setup(){
        rls = new RouteListService();
    }

    @Test
    public void routeHasRunPositiveTest(){
        Route route = new Route();
        String dt = "Thu Oct 13 11:33:47 PDT 2016";
        DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        Date routeTime = null;
        String routeId = "53299a16-022d-4051-91cb-3347b7488353";
        String routeName = "psu campus";

        try {
            routeTime = df.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            route.setId(routeId);
            route.setDateCreated(routeTime);
            route.setName(routeName);

            assertTrue(rls.routeHasRun(route));
        }
    }

    @Test
    public void routeHasRunNegativeTest(){
        Route route = new Route();
        Date routeTime = new Date();
        String routeId = "mocked route";
        String routeName = "not actually a route";

        route.setId(routeId);
        route.setDateCreated(routeTime);
        route.setName(routeName);

        assertFalse(rls.routeHasRun(route));
    }

}
