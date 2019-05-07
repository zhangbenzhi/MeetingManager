package com.example.meetingmanager.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

import org.greenrobot.greendao.annotation.Generated;

/**
 * 会议
 */
@Entity
public class MeetingBean implements Serializable {

    private static final long serialVersionUID = -8940196742313994743L;

    @Id(autoincrement = true)
    public Long id;
    public Long userId;
    public Long mettingRoomId;
    public String mettingName;
    public String joinerName;
    public boolean isOk;//是否通过审核

    @Generated(hash = 1138044097)
    public MeetingBean(Long id, Long userId, Long mettingRoomId, String mettingName,
            String joinerName, boolean isOk) {
        this.id = id;
        this.userId = userId;
        this.mettingRoomId = mettingRoomId;
        this.mettingName = mettingName;
        this.joinerName = joinerName;
        this.isOk = isOk;
    }

    @Generated(hash = 969729272)
    public MeetingBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMettingRoomId() {
        return this.mettingRoomId;
    }

    public void setMettingRoomId(Long mettingRoomId) {
        this.mettingRoomId = mettingRoomId;
    }

    public String getJoinerName() {
        return this.joinerName;
    }

    public void setJoinerName(String joinerName) {
        this.joinerName = joinerName;
    }

    public String getMettingName() {
        return this.mettingName;
    }

    public void setMettingName(String mettingName) {
        this.mettingName = mettingName;
    }

    public boolean getIsOk() {
        return this.isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

}
