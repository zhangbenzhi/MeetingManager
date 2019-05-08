package com.example.meetingmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.bean.MeetingRoomBean;
import com.example.meetingmanager.greendao.MeetingRoomBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetingDetailActivity extends AppCompatActivity {

    @BindView(R.id.meeting_room_name)
    TextView meetingRoomName;
    @BindView(R.id.meeting_name)
    TextView meetingName;
    @BindView(R.id.user_name)
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_detail);
        setTitle("会议详情");
        ButterKnife.bind(this);

        try {
            MeetingBean meetingBean = (MeetingBean) getIntent().getSerializableExtra("meet");
            Long mettingRoomId = meetingBean.mettingRoomId;
            MeetingRoomBean meetingRoomBean = MyApplication.getMyApplication().getDaoSession().getMeetingRoomBeanDao().queryBuilder().where(MeetingRoomBeanDao.Properties.Id.eq(mettingRoomId)).unique();
            meetingRoomName.setText("会议室名称：" + meetingRoomBean.name);
            meetingName.setText("会议名称：" + meetingBean.mettingName);
            userName.setText("与会者名称：" + meetingBean.joinerName);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
