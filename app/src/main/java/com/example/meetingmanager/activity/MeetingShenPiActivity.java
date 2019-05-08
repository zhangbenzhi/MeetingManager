package com.example.meetingmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.adapter.ShenPiMeetingAdapter;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.greendao.MeetingBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 会议审批
 */
public class MeetingShenPiActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.alert)
    TextView alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_shen_pi);
        setTitle("会议审批");
        ButterKnife.bind(this);

        MeetingBeanDao meetingBeanDao =
                MyApplication.getMyApplication().getDaoSession().getMeetingBeanDao();
        List<MeetingBean> list =
                meetingBeanDao.queryBuilder().where(MeetingBeanDao.Properties.IsOk.eq(false)).list();
        if (list == null || list.size() == 0) {
            alert.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            return;
        } else {
            alert.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        ShenPiMeetingAdapter shenPiMeetingAdapter = new ShenPiMeetingAdapter(this);
        recyclerView.setAdapter(shenPiMeetingAdapter);
        shenPiMeetingAdapter.setData(list);

    }
}
