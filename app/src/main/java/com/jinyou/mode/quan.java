package com.jinyou.mode;

import cn.bmob.v3.BmobObject;

public class quan extends BmobObject {
    private int img;
    private String quanname;

    public int getImsa() {
        return img;
    }

    public void setImsa(int imsa) {
        this.img = imsa;
    }

    public String getQuanname() {
        return quanname;
    }

    public void setQuanname(String quanname) {
        this.quanname = quanname;
    }
}
