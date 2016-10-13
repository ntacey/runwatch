package com.ntacey.runwatch.dao;

import com.ntacey.runwatch.models.Run;

import java.util.List;

/**
 * Created by Nick on 10/12/2016.
 */

public interface RunDAO {

    List<Run> getRuns();

    void addRun(Run run);

    //may need update and delete methods later on.. not adding those until needed
}
