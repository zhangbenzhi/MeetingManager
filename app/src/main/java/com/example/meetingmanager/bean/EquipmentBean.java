package com.example.meetingmanager.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 设备
 */
@Entity
public class EquipmentBean implements Serializable {

    private static final long serialVersionUID = -8940196742313994742L;

    @Id(autoincrement = true)
    public Long id;
    public String name;
    public Long meetingRoomId;
    @Generated(hash = 2125210373)
    public EquipmentBean(Long id, String name, Long meetingRoomId) {
        this.id = id;
        this.name = name;
        this.meetingRoomId = meetingRoomId;
    }
    @Generated(hash = 1113208600)
    public EquipmentBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getMeetingRoomId() {
        return this.meetingRoomId;
    }
    public void setMeetingRoomId(Long meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

}
