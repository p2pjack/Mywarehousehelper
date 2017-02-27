package com.uk.umf_solutions.warehousehelper.ui.whereMyStockFunction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uk.umf_solutions.warehousehelper.R;
import com.uk.umf_solutions.warehousehelper.core.listeners.WmsOnClickListener;
import com.uk.umf_solutions.warehousehelper.model.whereMyStock;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhereMyStockFragment_UI extends Fragment implements WmsOnClickListener {
    private View mRootView;
    private WmsListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private TextView mEmptyText;

    public WhereMyStockFragment_UI() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) container.findViewById(R.id.wms_recycler_view);
        mEmptyText = (TextView) container.findViewById(R.id.empty_text);
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_where_my_stock_fragment__ui, container, false);

        //setup RecyclerView
        ArrayList<whereMyStock> tempWms = new ArrayList<>();

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            mAdapter = new WmsListAdapter(tempWms,getContext(),this);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(mAdapter);


        if (tempWms.size() < 1){
            showEmptyTextMessage();
        }else{
            hideEmptyTextMessage();
        }

        return mRootView;
    }

    private void hideEmptyTextMessage() {
        mEmptyText.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showEmptyTextMessage() {

        mRecyclerView.setVisibility(View.GONE);
        mEmptyText.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnSelectedWMS(whereMyStock selectedWMS) {

    }

    @Override
    public void OnLongClickWMS(whereMyStock clickedWMS) {

    }
}
