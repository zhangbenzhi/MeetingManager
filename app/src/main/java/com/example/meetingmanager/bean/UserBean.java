package com.example.meetingmanager.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * 用户
 */
@Entity
public class UserBean implements Serializable {

    private static final long serialVersionUID = -8940196742313994740L;

    @Id(autoincrement = true)
    public Long id;
    public String userName;
    public String password;
    //0 普通用户  1：管理员
    public int type;
    @Generated(hash = 1293577070)
    public UserBean(Long id, String userName, String password, int type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
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
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }

}
