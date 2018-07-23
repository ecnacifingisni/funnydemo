package com.ecnacifingisni.funnydemo.bean;

import com.ecnacifingisni.funnydemo.Base.TypeFragment;

/**
 * funnydemo
 *
 * @author sjw
 * @date 2018/7/23.
 */
public class SliteLvItemBean {
    private String name;
    private TypeFragment typeFragment;

    public TypeFragment getTypeFragment() {
        return typeFragment;
    }

    public void setTypeFragment(TypeFragment typeFragment) {
        this.typeFragment = typeFragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
