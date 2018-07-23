package com.ecnacifingisni.funnydemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecnacifingisni.funnydemo.Base.BaseFragment;
import com.ecnacifingisni.funnydemo.R;

public class Test2Fragment extends BaseFragment {

    public Test2Fragment() {
    }


    public static Test2Fragment newInstance() {
        Test2Fragment fragment = new Test2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "");
        args.putString(ARG_PARAM2, "");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test2, container, false);
    }
}
