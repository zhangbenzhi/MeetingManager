package com.example.drivermanager.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 会议室
 */
@Entity
public class MeetingRoomBean implements Serializable {

    private static final long serialVersionUID = -8940196742313994741L;

    @Id(autoincrement = true)
    public Long id;
    public String name;
    public Long equipmentId;
    @Generated(hash = 1153396949)
    public MeetingRoomBean(Long id, String name, Long equipmentId) {
        this.id = id;
        this.name = name;
        this.equipmentId = equipmentId;
    }
    @Generated(hash = 625453573)
    public MeetingRoomBean() {
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
    public Long getEquipmentId() {
        return this.equipmentId;
    }
    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }


}
