package com.example.helloworld;

import java.io.Serializable;

class UserInfo implements Serializable {
    private String userName;
    private String password;
    private String sex;
    private String phone;
    private String sms;

    public UserInfo(String userName, String password, String sex, String phone, String sms) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.sms = sms;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}
