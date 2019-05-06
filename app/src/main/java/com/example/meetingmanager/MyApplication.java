package com.example.meetingmanager;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.meetingmanager.greendao.DaoMaster;
import com.example.meetingmanager.greendao.DaoSession;

public class MyApplication extends Application {

    private DaoSession daoSession;
    private static MyApplication myApplication;

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
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }
}
