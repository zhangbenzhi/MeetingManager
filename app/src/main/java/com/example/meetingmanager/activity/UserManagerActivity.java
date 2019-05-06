package com.example.meetingmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.UserBean;
import com.example.meetingmanager.greendao.UserBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserManagerActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        ButterKnife.bind(this);
        setTitle("用户管理");

        etUsername.setText(MyApplication.userBean.userName);
        etPassword.setText(MyApplication.userBean.password);
    }

    @OnClick({R.id.update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update:
                update();
                break;
        }
    }

    private void update() {
        String strName = etUsername.getText().toString();
        String strPass = etPassword.getText().toString();
        if (TextUtils.isEmpty(strName)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(strPass)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        UserBeanDao userBeanDao = MyApplication.getMyApplication().getDaoSession().getUserBeanDao();
        List<UserBean> list = userBeanDao.queryBuilder()
                .where(UserBeanDao.Properties.UserName.eq(strName))
                .list();
        if (list != null && list.size() > 0) {
            Toast.makeText(this, "该用户名已存在，请修改", Toast.LENGTH_SHORT).show();
            return;
        }
        MyApplication.userBean.userName = strName;
        MyApplication.userBean.password = strPass;
        try {
            userBeanDao.update(MyApplication.userBean);
            Toast.makeText(this, "修改用户信息成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
