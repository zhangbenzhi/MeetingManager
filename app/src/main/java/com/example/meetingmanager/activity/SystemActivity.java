package com.example.meetingmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.adapter.SystemAdapter;
import com.example.meetingmanager.bean.UserBean;
import com.example.meetingmanager.greendao.UserBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.alert)
    TextView alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        setTitle("系统管理");
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SystemAdapter systemAdapter = new SystemAdapter(this);
        recyclerView.setAdapter(systemAdapter);
        List<UserBean> list = MyApplication.getMyApplication().getDaoSession().getUserBeanDao().queryBuilder().where(UserBeanDao.Properties.Id.notEq(MyApplication.userBean.id)).list();
        if (list == null || list.size() == 0) {
            alert.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            return;
        }
        alert.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        systemAdapter.setData(list);
    }
}
