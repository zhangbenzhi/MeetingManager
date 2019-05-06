package com.example.meetingmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.UserBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.order)
    Button btnOrder;
    @BindView(R.id.user_info)
    Button btnUserInfo;
    @BindView(R.id.equipment_manager)
    Button btnEquipmentManager;
    @BindView(R.id.system_manager)
    Button btnSystemManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        UserBean userBean = MyApplication.userBean;
        switch (userBean.type) {
            case 0:
                btnOrder.setVisibility(View.VISIBLE);
                btnUserInfo.setVisibility(View.VISIBLE);
                btnEquipmentManager.setVisibility(View.GONE);
                btnSystemManager.setVisibility(View.GONE);
                break;
            case 1:
                btnOrder.setVisibility(View.GONE);
                btnUserInfo.setVisibility(View.GONE);
                btnEquipmentManager.setVisibility(View.VISIBLE);
                btnSystemManager.setVisibility(View.VISIBLE);
                break;
        }
    }

    @OnClick({R.id.order, R.id.user_info, R.id.equipment_manager, R.id.system_manager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order:
                startActivity(new Intent(this, OrderActivity.class));
                break;
            case R.id.user_info:
                startActivity(new Intent(this, UserManagerActivity.class));
                break;
            case R.id.equipment_manager:
                startActivity(new Intent(this, EquipmentActivity.class));
                break;
            case R.id.system_manager:
                startActivity(new Intent(this, SystemActivity.class));
                break;
        }
    }

}
