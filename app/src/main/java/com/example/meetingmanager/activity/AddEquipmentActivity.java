package com.example.meetingmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.EquipmentBean;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.bean.MeetingRoomBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddEquipmentActivity extends AppCompatActivity {

    @BindView(R.id.order_meeting)
    Button order;
    @BindView(R.id.et_meetname)
    EditText meetname;
    @BindView(R.id.spinner)
    Spinner spinner;
    public MeetingRoomBean selectedBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equipment);
        ButterKnife.bind(this);
        setTitle("添加设备");

        //获取会议室
        List<MeetingRoomBean> meetingRoomBeans = MyApplication.getMyApplication().getDaoSession().getMeetingRoomBeanDao().loadAll();
        List<String> str = new ArrayList<>();
        str.add("仓库");
        if (meetingRoomBeans != null && meetingRoomBeans.size() > 0) {
            for (MeetingRoomBean meetingRoomBean : meetingRoomBeans) {
                str.add(meetingRoomBean.name);
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, str);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                    if (pos == 0) {
                        selectedBean = null;
                    } else {
                        selectedBean = meetingRoomBeans.get(pos - 1);
                    }
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
                    Toast.makeText(this, "请输入设备名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                EquipmentBean equipmentBean = new EquipmentBean();
                equipmentBean.name = meetname.getText().toString();
                if (selectedBean == null) {
                    equipmentBean.meetingRoomId = 0L;
                } else {
                    equipmentBean.meetingRoomId = selectedBean.id;
                }
                MyApplication.getMyApplication().getDaoSession().getEquipmentBeanDao().insert(equipmentBean);
                Toast.makeText(this, "设备添加成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
