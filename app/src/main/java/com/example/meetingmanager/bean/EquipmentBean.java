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
    @Generated(hash = 787400167)
    public EquipmentBean(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
