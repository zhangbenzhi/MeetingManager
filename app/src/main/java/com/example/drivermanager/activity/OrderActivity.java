package com.example.drivermanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drivermanager.MyApplication;
import com.example.drivermanager.R;
import com.example.drivermanager.adapter.MeetingAdapter;
import com.example.drivermanager.bean.MeetingBean;
import com.example.drivermanager.greendao.MeetingBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 运营申请
 */
public class OrderActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.add)
    ImageView iv;
    @BindView(R.id.alert)
    TextView tvAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        setTitle("运营申请");

    }

    @Override
    protected void onResume() {
        super.onResume();
        //获取所有该用户已预订的会议
        List<MeetingBean> list = MyApplication.
                getMyApplication().
                getDaoSession().
                getMeetingBeanDao().
                queryBuilder().
                where(MeetingBeanDao.Properties.UserId.eq(MyApplication.userBean.id),MeetingBeanDao.Properties.IsOk.eq(true))
                .list();
        if (list == null || list.size() == 0) {
            tvAlert.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            return;
        }
        tvAlert.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        MeetingAdapter meetingAdapter = new MeetingAdapter(this);
        recyclerView.setAdapter(meetingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        meetingAdapter.setData(list);
    }

    @OnClick({R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
        }
    }

    //添加会议
    private void add() {
        startActivity(new Intent(this, AddOrderActivity.class));
    }


}
