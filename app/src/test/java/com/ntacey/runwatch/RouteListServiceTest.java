package com.ntacey.runwatch;

import com.ntacey.runwatch.dao.RunDAOImpl;
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


    private RunDAOImpl rundao;
    private RouteListService rls;

    @Before
    public void setup(){
        rundao = new RunDAOImpl();
        rls = new RouteListService();
    }

    @Test
    public void routeHasRunPositiveTest(){
        Route route = new Route();
        String dt = "Thu Oct 13 11:33:47 PDT 2016";
        DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        Date date = null;
        try {
            date = df.parse(dt);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {

            route.setId("53299a16-022d-4051-91cb-3347b7488353");
            route.setDateCreated(date);
            route.setName("psu campus");

            assertTrue(rls.routeHasRun(route));
        }
    }

    @Test
    public void routeHasRunNegativeTest(){
        Route route = new Route();
        Date timestamp = new Date();

        route.setId("mocked route");
        route.setDateCreated(timestamp);
        route.setName("not actually a route");

        assertFalse(rls.routeHasRun(route));
    }

}
