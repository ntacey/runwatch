package com.ntacey.runwatch;

import com.ntacey.runwatch.services.NewRouteService;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Nick on 10/13/2016.
 */

public class NewRouteServiceTest {
    private NewRouteService nrs;

    @Before
    public void setup() {
        nrs = new NewRouteService();
    }

    @Test
    public void formatIntToStringPositiveTest1() {
        int x = 5;
        assertEquals("05", nrs.formatIntToString(x));
    }

    @Test
    public void formatIntToStringPositiveTest2() {
        int x = 12;
        assertEquals("12", nrs.formatIntToString(x));
    }

    @Test
    public void formatIntToStringPositiveTest3() {
        int x = 0;
        assertEquals("00", nrs.formatIntToString(x));
    }


    @Test
    public void formatIntToStringNegativeTest1() {
        int x = 5;
        assertNotEquals("5", nrs.formatIntToString(x));
    }

    @Test
    public void formatIntToStringNegativeTest2() {
        int x = 12;
        assertNotEquals("012", nrs.formatIntToString(x));
    }

}
