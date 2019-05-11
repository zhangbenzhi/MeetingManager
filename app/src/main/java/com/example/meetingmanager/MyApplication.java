package com.example.meetingmanager;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.meetingmanager.bean.MeetingRoomBean;
import com.example.meetingmanager.bean.UserBean;
import com.example.meetingmanager.greendao.DaoMaster;
import com.example.meetingmanager.greendao.DaoSession;
import com.example.meetingmanager.greendao.EquipmentBeanDao;

import java.util.List;

public class MyApplication extends Application {

    private DaoSession daoSession;
    private static MyApplication myApplication;
    public static UserBean userBean;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        init();
    }

    private void init() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "meet.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
        List<MeetingRoomBean> meetingRoomBeans = getDaoSession().getMeetingRoomBeanDao().loadAll();
        if (meetingRoomBeans == null || meetingRoomBeans.size() == 0) {
            //添加几个默认的会议室
            for (int i = 0; i < 10; i++) {
                MeetingRoomBean meetingRoomBean = new MeetingRoomBean();
                meetingRoomBean.name = "会议室" + (i + 1);
                getDaoSession().getMeetingRoomBeanDao().insert(meetingRoomBean);
            }
        }
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }
}
