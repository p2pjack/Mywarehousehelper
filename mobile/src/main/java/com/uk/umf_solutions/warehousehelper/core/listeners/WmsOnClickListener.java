package com.uk.umf_solutions.warehousehelper.core.listeners;

import com.uk.umf_solutions.warehousehelper.model.whereMyStock;

/**
 * Created by Eaun-Ballinger on 27/02/2017.
 *
 */

public interface WmsOnClickListener {

    void OnSelectedWMS(whereMyStock selectedWMS);
    void OnLongClickWMS(whereMyStock clickedWMS);
}
