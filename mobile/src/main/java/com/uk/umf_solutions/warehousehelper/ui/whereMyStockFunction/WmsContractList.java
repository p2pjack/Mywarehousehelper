package com.uk.umf_solutions.warehousehelper.ui.whereMyStockFunction;

import com.uk.umf_solutions.warehousehelper.core.listeners.OnDatabaseOperationCompleteListener;
import com.uk.umf_solutions.warehousehelper.model.whereMyStock;

import java.util.List;

/**
 * Created by Eaun-Ballinger on 08/03/2017.
 *
 */

public interface WmsContractList {
    public interface View {
        void showWmsList(List<whereMyStock> customers);

        void showAddWmsForm();

        void showDeleteWmsPrompt(whereMyStock wms);

        void showEditWmsForm(whereMyStock wms);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);

    }

    public interface Actions {
        void loadWmsList();

        whereMyStock getWms(long id);

        void onWmsSelected(whereMyStock wms);

        void onAddWmsButtonClicked();

        void addWms(whereMyStock wms);

        void onDeleteWmsButtonClicked(whereMyStock wms);

        void deleteWms(whereMyStock wms);

        void onEditWmsButtonClicked(whereMyStock wms);

        void updateWms(whereMyStock wms);

    }

    public interface Repository {
        List<whereMyStock> getAllWmsList();

        whereMyStock getWmsById(long id);

        void deleteWms(whereMyStock wms, OnDatabaseOperationCompleteListener listener);

        void addWms(whereMyStock wms, OnDatabaseOperationCompleteListener listener);

        void updateWms(whereMyStock wms, OnDatabaseOperationCompleteListener listener);

    }
}
