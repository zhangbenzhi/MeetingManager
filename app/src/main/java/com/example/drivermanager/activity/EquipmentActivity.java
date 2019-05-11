package com.example.drivermanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivermanager.MyApplication;
import com.example.drivermanager.R;
import com.example.drivermanager.adapter.EquipmentAdapter;
import com.example.drivermanager.bean.EquipmentBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 出租车管理
 */
public class EquipmentActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.add)
    ImageView iv;
    @BindView(R.id.alert)
    TextView tvAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        ButterKnife.bind(this);
        setTitle("出租车管理");

    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            List<EquipmentBean> list = MyApplication.
                    getMyApplication().
                    getDaoSession().
                    getEquipmentBeanDao().loadAll();
            if (list == null || list.size() == 0) {
                tvAlert.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                return;
            }
            tvAlert.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            EquipmentAdapter equipmentAdapter = new EquipmentAdapter(this);
            recyclerView.setAdapter(equipmentAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            equipmentAdapter.setData(list);
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
        }
    }

    //添加设备
    private void add() {
        startActivity(new Intent(this, AddEquipmentActivity.class));
    }


}
