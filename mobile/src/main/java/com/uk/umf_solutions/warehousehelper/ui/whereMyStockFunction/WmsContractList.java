package com.uk.umf_solutions.warehousehelper.ui.whereMyStockFunction;

import com.uk.umf_solutions.warehousehelper.core.listeners.OnDatabaseOperationCompleteListener;
import com.uk.umf_solutions.warehousehelper.model.whereMyStock;

import java.util.List;

/**
 * Created by Eaun-Ballinger on 08/03/2017.
 *
 */

public interface WmsContractList {
    public interface View{
        void showCustomers(List<whereMyStock> customers);
        void showAddCustomerForm();
        void showDeleteCustomerPrompt(whereMyStock wms);
        void showEditCustomerForm(whereMyStock wms);
        void showEmptyText();
        void hideEmptyText();
        void showMessage(String message);

    }

    public interface Actions{
        void loadCustomers();
        whereMyStock getCustomer(long id);
        void onCustomerSelected(whereMyStock wms);
        void onAddCustomerButtonClicked();
        void addCustomer(whereMyStock wms);
        void onDeleteCustomerButtonClicked(whereMyStock wms);
        void deleteCustomer(whereMyStock wms);
        void onEditCustomerButtonClicked(whereMyStock wms);
        void updateCustomer(whereMyStock wms);

    }

    public interface Repository{
        List<whereMyStock> getAllCustomers();
        whereMyStock getCustomerById(long id);
        void deleteCustomer(whereMyStock wms, OnDatabaseOperationCompleteListener listener);
        void addCustomer(whereMyStock wms, OnDatabaseOperationCompleteListener listener);
        void updateCustomer(whereMyStock wms, OnDatabaseOperationCompleteListener listener);

    }
}
