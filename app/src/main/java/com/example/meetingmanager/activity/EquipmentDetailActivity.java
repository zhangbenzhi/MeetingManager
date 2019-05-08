package com.example.meetingmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.EquipmentBean;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.bean.MeetingRoomBean;
import com.example.meetingmanager.greendao.MeetingRoomBeanDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EquipmentDetailActivity extends AppCompatActivity {

    @BindView(R.id.meeting_name)
    TextView meetingName;
    @BindView(R.id.spinner)
    Spinner spinner;
    public MeetingRoomBean selectedBean;
    private EquipmentBean equipmentBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_detail);
        setTitle("设备详情");
        ButterKnife.bind(this);


        try {
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
            equipmentBean = (EquipmentBean) getIntent().getSerializableExtra("equipmentBean");
            meetingName.setText("设备名称：" + equipmentBean.name);
            Long meetingRoomId = equipmentBean.meetingRoomId;

            if (meetingRoomId == null || meetingRoomId == 0) {
                spinner.setSelection(0);
            } else {
                for (int i = 0; i < meetingRoomBeans.size(); i++) {
                    if (equipmentBean.meetingRoomId.equals(meetingRoomBeans.get(i).getId())) {
                        spinner.setSelection(i + 1);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update:
                if (selectedBean == null) {
                    equipmentBean.meetingRoomId = 0L;
                } else {
                    equipmentBean.meetingRoomId = selectedBean.id;
                }
                MyApplication.getMyApplication().getDaoSession().getEquipmentBeanDao().update(equipmentBean);
                Toast.makeText(this, "设备信息修改成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
