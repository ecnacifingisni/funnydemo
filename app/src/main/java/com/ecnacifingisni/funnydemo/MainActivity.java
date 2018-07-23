package com.ecnacifingisni.funnydemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecnacifingisni.funnydemo.Base.BaseFragment;
import com.ecnacifingisni.funnydemo.Base.HomeBaseMsg;
import com.ecnacifingisni.funnydemo.Base.TypeFragment;
import com.ecnacifingisni.funnydemo.adapter.HomeBaseAdapter;
import com.ecnacifingisni.funnydemo.bean.SliteLvItemBean;
import com.ecnacifingisni.funnydemo.fragment.Test1Fragment;
import com.ecnacifingisni.funnydemo.fragment.Test2Fragment;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView ivShowLateralSpreads;
    private TextView tvShowFragmentNameHome;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout rlLateralSpreads;
    private ListView lvLateralSpreadsHome;
    private HomeBaseAdapter adapter;
    private List<SliteLvItemBean> listHome;

    private BaseFragment showFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Test1Fragment test1Fragment;
    private Test2Fragment test2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        showBeginFragment();
    }

    private void showBeginFragment() {
        tvShowFragmentNameHome.setText(listHome.get(0).getName());
        fragmentTransaction = fragmentManager.beginTransaction();
        if (test1Fragment == null) {
            test1Fragment = Test1Fragment.newInstance();
            fragmentTransaction.add(R.id.fl_home, test1Fragment);
        } else {
            fragmentTransaction.show(test1Fragment);
        }
        showFragment = test1Fragment;
        fragmentTransaction.commit();
    }

    private void initListener() {
        ivShowLateralSpreads.setOnClickListener(this);
        lvLateralSpreadsHome.setOnItemClickListener(this);
    }

    private void initView() {
        ivShowLateralSpreads = findViewById(R.id.iv_show_lateral_spreads_home);
        mDrawerLayout = findViewById(R.id.dl_home);
        rlLateralSpreads = findViewById(R.id.rl_lateral_spreads_home);
        lvLateralSpreadsHome = findViewById(R.id.lv_lateral_spreads_home);
        tvShowFragmentNameHome = findViewById(R.id.tv_show_fragment_name_home);
        adapter = new HomeBaseAdapter(this);
        lvLateralSpreadsHome.setAdapter(adapter);
        listHome = HomeBaseMsg.INSTANCE.getHome();
        adapter.setList(listHome);
        fragmentManager = getFragmentManager();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_show_lateral_spreads_home:
                showLateralSpreads();
                break;
            default:
                break;
        }
    }

    private void showLateralSpreads() {
        if (mDrawerLayout.isDrawerOpen(rlLateralSpreads)) {
            mDrawerLayout.closeDrawer(rlLateralSpreads);
        } else {
            mDrawerLayout.openDrawer(rlLateralSpreads);
        }
    }

    private boolean hideLateralSpreads() {
        if (mDrawerLayout.isDrawerOpen(rlLateralSpreads)) {
            mDrawerLayout.closeDrawer(rlLateralSpreads);
            return true;
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        hideLateralSpreads();
        SliteLvItemBean bean = listHome.get(position);
        tvShowFragmentNameHome.setText(bean.getName());
        showFragment(bean.getTypeFragment());
    }

    private void showFragment(TypeFragment typeFragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (showFragment != null) {
            fragmentTransaction.hide(showFragment);
        }
        switch (typeFragment) {
            case TEST1:
                if (test1Fragment == null) {
                    test1Fragment = Test1Fragment.newInstance();
                    fragmentTransaction.add(R.id.fl_home, test1Fragment);
                } else {
                    fragmentTransaction.show(test1Fragment);
                }
                showFragment = test1Fragment;
                break;
            case TeST2:
                if (test2Fragment == null) {
                    test2Fragment = Test2Fragment.newInstance();
                    fragmentTransaction.add(R.id.fl_home, test2Fragment);
                } else {
                    fragmentTransaction.show(test2Fragment);
                }
                showFragment = test2Fragment;
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
}
