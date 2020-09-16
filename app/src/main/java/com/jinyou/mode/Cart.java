package com.jinyou.mode;

import cn.bmob.v3.BmobObject;

/**
 * Cart类及名片
 */
public class Cart extends BmobObject {
    private Integer img;
    private Integer cartid;
    private  String cartname;
    private boolean cartstat=true;//名片状态
    private String company;//公司
    private String department;//部门
    private String position;//职位
    private String mobile;//电话
    private String email;//邮箱
    private String fax;//传真
    private String theurl;//网址
    private String address;//地址
    private String cartdate;//名片交换日期
    private String password;
    private boolean zhuangtai;//登录状态

    public Cart() {
    }

    public Integer getCartid() {
        return cartid;
    }

    public Cart(String cartname, String company, String department, String position, String mobile, String email, String fax, String theurl, String address) {
        this.cartname = cartname;
        this.company = company;
        this.department = department;
        this.position = position;
        this.mobile = mobile;
        this.email = email;
        this.fax = fax;
        this.theurl = theurl;
        this.address = address;

    }

    public boolean isZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(boolean zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getCartname() {
        return cartname;
    }

    public void setCartname(String cartname) {
        this.cartname = cartname;
    }

    public boolean isCartstat() {
        return cartstat;
    }

    public void setCartstat(boolean cartstat) {
        this.cartstat = cartstat;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTheurl() {
        return theurl;
    }

    public void setTheurl(String theurl) {
        this.theurl = theurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCartdate() {
        return cartdate;
    }

    public void setCartdate(String cartdate) {
        this.cartdate = cartdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
