package com.uk.umf_solutions.warehousehelper.ui.whereMyStockFunction;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uk.umf_solutions.warehousehelper.R;
import com.uk.umf_solutions.warehousehelper.core.listeners.WmsOnClickListener;
import com.uk.umf_solutions.warehousehelper.model.whereMyStock;

import java.util.List;

/**
 * Created by Eaun-Ballinger on 27/02/2017.
 *
 *
 */

public class WmsListAdapter extends RecyclerView.Adapter<WmsListAdapter.WMSViewHolder> {




    private ThreadLocal<List<whereMyStock>> mWMS;
    private Context mContext;
    private final WmsOnClickListener mListener;

    public WmsListAdapter(List<whereMyStock> wms,
                          Context mContext,
                          WmsOnClickListener mListener) {
        this.mWMS = new ThreadLocal<>();
        this.mWMS.set(wms);
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @Override
    public WMSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View wmsView;
        wmsView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_view_items,parent,false);
        return new WMSViewHolder(wmsView);
    }

    @Override
    public void onBindViewHolder(WMSViewHolder holder, int position) {
        whereMyStock wms = mWMS.get().get(position);
        holder.mTITLE.setText(wms.getMessageTitle());
        holder.mACTION.setText(wms.getMessageActions());
        holder.mMESSAGE.setText(wms.getMessageDescription());

    }

    @Override
    public int getItemCount() {

        return mWMS.get().size();

    }

    public class WMSViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener,View.OnLongClickListener{
                 TextView mTITLE;
                 TextView mACTION;
                 TextView mMESSAGE;

        public WMSViewHolder(View itemView) {
            super(itemView);
            mTITLE = (TextView) itemView.findViewById(R.id.title);
            mACTION = (TextView) itemView.findViewById(R.id.action);
            mMESSAGE = (TextView) itemView.findViewById(R.id.message);

        }

        @Override
        public void onClick(View view) {
            whereMyStock selected = mWMS.get().get(getLayoutPosition());
            mListener.OnSelectedWMS(selected);

        }

        @Override
        public boolean onLongClick(View view) {
            whereMyStock longSelected = mWMS.get().get(getLayoutPosition());
            mListener.OnLongClickWMS(longSelected);
            return true;
        }
    }
}

