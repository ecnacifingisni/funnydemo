package com.ecnacifingisni.funnydemo.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecnacifingisni.funnydemo.Base.BaseFragment;
import com.ecnacifingisni.funnydemo.R;

public class Test1Fragment extends BaseFragment {
    public Test1Fragment() {
    }

    public static Test1Fragment newInstance() {
        Test1Fragment fragment = new Test1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "");
        args.putString(ARG_PARAM2, "");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test1, container, false);
    }
}
