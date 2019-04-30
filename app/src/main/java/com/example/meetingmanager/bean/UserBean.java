package com.example.meetingmanager.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户
 */
@Entity
public class UserBean {

    public String id;
    public String userName;
    public String password;

    @Generated(hash = 1930381788)
    public UserBean(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
