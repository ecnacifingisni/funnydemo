package com.ecnacifingisni.funnydemo.Base;

import com.ecnacifingisni.funnydemo.bean.SliteLvItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * funnydemo
 *
 * @author sjw
 * @date 2018/7/23.
 */
public enum HomeBaseMsg {
    INSTANCE;
    private List<SliteLvItemBean> listHome;

    public List<SliteLvItemBean> getHome() {
        if (listHome == null) {
            listHome = new ArrayList<>();
            SliteLvItemBean bean1 = new SliteLvItemBean();
            bean1.setName("测试");
            bean1.setTypeFragment(TypeFragment.TEST1);
            listHome.add(bean1);
            SliteLvItemBean bean2 = new SliteLvItemBean();
            bean2.setName("测试2");
            bean2.setTypeFragment(TypeFragment.TeST2);
            listHome.add(bean2);
        }
        return listHome;
    }
}
