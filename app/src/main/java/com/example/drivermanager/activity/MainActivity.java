package com.example.drivermanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.drivermanager.MyApplication;
import com.example.drivermanager.R;
import com.example.drivermanager.bean.UserBean;

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
    @BindView(R.id.meeting_shenpi)
    Button btnMeetingShenpi;
    @BindView(R.id.logout)
    Button logout;


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
                btnMeetingShenpi.setVisibility(View.GONE);
                btnEquipmentManager.setVisibility(View.GONE);
                btnSystemManager.setVisibility(View.GONE);
                break;
            case 1:
                btnOrder.setVisibility(View.GONE);
                btnUserInfo.setVisibility(View.GONE);
                btnMeetingShenpi.setVisibility(View.VISIBLE);
                btnEquipmentManager.setVisibility(View.VISIBLE);
                btnSystemManager.setVisibility(View.VISIBLE);
                break;
        }
    }

    @OnClick({R.id.order, R.id.user_info, R.id.equipment_manager, R.id.system_manager, R.id.meeting_shenpi, R.id.logout})
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
            case R.id.meeting_shenpi:
                startActivity(new Intent(this, MeetingShenPiActivity.class));
                break;
            case R.id.logout:
                MyApplication.userBean = null;
                Toast.makeText(this, "退出登录成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    /**
     * 营运数据：
     * id，载客里程，营运收入，服务次数，司机id
     * 司机：
     * id，姓名，性别，手机号，驾龄
     * 管理员：
     * id，姓名，性别
     */

}
