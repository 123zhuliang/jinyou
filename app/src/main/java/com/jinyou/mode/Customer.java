package com.jinyou.mode;

import cn.bmob.v3.BmobObject;

public class Customer extends BmobObject {
    private String mobile;
    private String password;

    public Customer(){

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
