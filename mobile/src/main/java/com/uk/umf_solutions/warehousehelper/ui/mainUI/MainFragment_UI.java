package com.uk.umf_solutions.warehousehelper.ui.mainUI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uk.umf_solutions.warehousehelper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment_UI extends Fragment {


    public MainFragment_UI() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_fragment__ui, container, false);
    }

}
