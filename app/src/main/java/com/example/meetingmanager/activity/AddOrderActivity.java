package com.example.meetingmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.bean.MeetingRoomBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddOrderActivity extends AppCompatActivity {

    @BindView(R.id.order_meeting)
    Button order;
    @BindView(R.id.et_username)
    EditText username;
    @BindView(R.id.et_meetname)
    EditText meetname;
    @BindView(R.id.spinner)
    Spinner spinner;
    public MeetingRoomBean selectedBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        ButterKnife.bind(this);
        setTitle("预定会议");

        //获取会议室
        List<MeetingRoomBean> meetingRoomBeans = MyApplication.getMyApplication().getDaoSession().getMeetingRoomBeanDao().loadAll();
        List<String> str = new ArrayList<>();
        if (meetingRoomBeans != null && meetingRoomBeans.size() > 0) {
            for (MeetingRoomBean meetingRoomBean : meetingRoomBeans) {
                str.add(meetingRoomBean.name);
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, str);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                    selectedBean = meetingRoomBeans.get(pos);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            spinner.setSelection(0);
        }
    }

    @OnClick({R.id.order_meeting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_meeting:
                if (TextUtils.isEmpty(meetname.getText().toString())) {
                    Toast.makeText(this, "请输入会议名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(username.getText().toString())) {
                    Toast.makeText(this, "请输入与会者名字", Toast.LENGTH_SHORT).show();
                    return;
                }
                MeetingBean meetingBean = new MeetingBean();
                meetingBean.isOk = false;
                meetingBean.joinerName = username.getText().toString();
                meetingBean.mettingName = meetname.getText().toString();
                meetingBean.mettingRoomId = selectedBean.id;
                MyApplication.getMyApplication().getDaoSession().getMeetingBeanDao().insert(meetingBean);
                break;
        }
    }

}
