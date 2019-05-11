package com.example.meetingmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.UserBean;
import com.example.meetingmanager.greendao.UserBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注冊
 */
public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.rg)
    RadioGroup rg;
    private int checkedUserType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.rb01:
                        checkedUserType = 0;
                        break;
                    case R.id.rb02:
                        checkedUserType = 1;
                        break;
                }
            }
        });
    }

    @OnClick({R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                register();
                break;
        }
    }

    //注册
    private void register() {
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
            Toast.makeText(this, "该用户名已存在，请更换", Toast.LENGTH_SHORT).show();
            return;
        }
        UserBean userBean = new UserBean();
        userBean.userName = strName;
        userBean.password = strPass;
        userBean.type = checkedUserType;
        //注册
        userBeanDao.insert(userBean);
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
