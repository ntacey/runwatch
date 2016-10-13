package com.ntacey.runwatch.dao;

import com.ntacey.runwatch.models.Run;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Nick on 10/12/2016.
 */

public class RunDAOImpl implements RunDAO {

    private Realm realm = Realm.getDefaultInstance();

    @Override
    public List<Run> getRuns(){
        RealmResults<Run> query = realm.where(Run.class).findAll();
        List<Run> runs = query;
        return runs;
    }

    @Override
    public void addRun(Run run) {
        realm.beginTransaction();
        realm.copyToRealm(run);
        realm.commitTransaction();
    }
}
