package com.uk.umf_solutions.warehousehelper.core;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.uk.umf_solutions.warehousehelper.model.whereMyStock;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Eaun-Ballinger on 05/03/2017.
 *
 */

public class WarehouseApplication extends Application {

    public static AtomicLong myNotesPrimaryKey;
    public static AtomicLong WmsPrimaryKey;
    public static AtomicLong cigmaPrimaryKey;
    public static AtomicLong supplierPrimaryKey;
    private static WarehouseApplication instance = new WarehouseApplication();
    private SharedPreferences sharedPreferences;

    public static WarehouseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDefaultProducts();
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("warehouse.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);

        Realm realm = Realm.getDefaultInstance();

        try {
            WmsPrimaryKey = new AtomicLong(realm.where(whereMyStock.class).max("id").longValue());
        } catch (Exception e) {
            realm.beginTransaction();
            whereMyStock transaction = new whereMyStock();
            transaction.setId(0);
            realm.copyToRealm(transaction);
            WmsPrimaryKey = new AtomicLong(realm.where(whereMyStock.class).max("id").longValue());
            RealmResults<whereMyStock> results = realm.where(whereMyStock.class).equalTo("id", 0).findAll();
            results.deleteAllFromRealm();
            realm.commitTransaction();
        }

        realm.close();
    }


    private void initDefaultProducts() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        if (sharedPreferences.getBoolean(Constants.FIRST_RUN, true)) {
//            startService(new Intent(this, AddInitialDataService.class));
//            editor.putBoolean(Constants.FIRST_RUN, false).commit();
//        }
    }
}
