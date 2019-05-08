package com.example.meetingmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.greendao.MeetingBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 会议审批
 */
public class MeetingShenPiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_shen_pi);
        setTitle("会议审批");

        MeetingBeanDao meetingBeanDao =
                MyApplication.getMyApplication().getDaoSession().getMeetingBeanDao();
        List<MeetingBean> list =
                meetingBeanDao.queryBuilder().where(MeetingBeanDao.Properties.IsOk.eq(false)).list();

    }
}
