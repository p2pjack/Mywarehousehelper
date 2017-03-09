package com.uk.umf_solutions.warehousehelper.Data.Realm;

import com.uk.umf_solutions.warehousehelper.core.WarehouseApplication;
import com.uk.umf_solutions.warehousehelper.core.listeners.OnDatabaseOperationCompleteListener;
import com.uk.umf_solutions.warehousehelper.model.whereMyStock;
import com.uk.umf_solutions.warehousehelper.ui.whereMyStockFunction.WmsContractList;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

import static android.R.attr.id;

/**
 * Created by Eaun-Ballinger on 03/03/2017.
 *
 */

public class WmsRealmRepository implements WmsContractList {

    private final static String LOG_TAG = WmsRealmRepository.class.getSimpleName();

    public WmsRealmRepository() {

    }

    public List<whereMyStock> getAllCustomers() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<whereMyStock> customers = realm.where(whereMyStock.class).findAll();
        customers = customers.sort("id", Sort.DESCENDING);
        List<whereMyStock> result = realm.copyFromRealm(customers);
        realm.close();
        return result;
    }

    public whereMyStock getCustomerById(long id) {
        Realm realm = Realm.getDefaultInstance();
        whereMyStock inMemoryCustomer = null;
        try {
            whereMyStock customer = realm.where(whereMyStock.class).equalTo("id", id).findFirst();
            inMemoryCustomer = realm.copyFromRealm(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        realm.close();
        return inMemoryCustomer;
    }

    public void deleteCustomer(whereMyStock customer, final OnDatabaseOperationCompleteListener listener) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm backgroundRealm) {
                RealmResults<whereMyStock> clients = backgroundRealm.where(whereMyStock.class).findAll();
                whereMyStock clientToBeDeleted = clients.where().equalTo("id", id).findFirst();
                clientToBeDeleted.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
                listener.onSQLOperationSucceded("Deleted");

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();
                listener.onSQLOperationSucceded(error.getMessage());
            }
        });

    }

    public void addCustomer(final whereMyStock customer, final OnDatabaseOperationCompleteListener listener) {
        final Realm insertRealm = Realm.getDefaultInstance();
        final long id = WarehouseApplication.WmsPrimaryKey.incrementAndGet();
        insertRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm backgroundRealm) {
                customer.setId(id);
                backgroundRealm.copyToRealm(customer);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                insertRealm.close();
                listener.onSQLOperationSucceded("Saved");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                insertRealm.close();
                listener.onSQLOperationFailed(error.getMessage());
            }
        });

    }

    public void updateCustomer(whereMyStock customer, OnDatabaseOperationCompleteListener listener) {

    }
}
