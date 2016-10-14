package com.ntacey.runwatch.services;

/**
 * Created by PC on 10/13/2016.
 */

public class NewRouteService {

    /*
     * This method is used for formatting time integer denominations. Changes int
     * to String, and prepends a 0 if needed.
     */
    public String formatIntToString(int denom) {
        StringBuilder dString = new StringBuilder(String.valueOf(denom));
        if (denom < 10) {
            dString.insert(0, "0");
        }

        return dString.toString();
    }
}
