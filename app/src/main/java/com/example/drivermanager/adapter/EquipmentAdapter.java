package com.example.drivermanager.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivermanager.MyApplication;
import com.example.drivermanager.R;
import com.example.drivermanager.activity.EquipmentDetailActivity;
import com.example.drivermanager.bean.EquipmentBean;

import java.util.ArrayList;
import java.util.List;

//设备
public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder> {

    private List<EquipmentBean> equipmentBeans = new ArrayList<>();
    private Activity activity;

    public EquipmentAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public EquipmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EquipmentViewHolder(activity.getLayoutInflater().inflate(R.layout.item_meeting, null));
    }

    @Override
    public void onBindViewHolder(@NonNull EquipmentViewHolder meetingViewHolder, int i) {
        EquipmentBean equipmentBean = equipmentBeans.get(i);
        meetingViewHolder.name.setText("设备名称：" + equipmentBean.getName());
        meetingViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, EquipmentDetailActivity.class);
                intent.putExtra("equipmentBean", equipmentBean);
                activity.startActivity(intent);
            }
        });
        meetingViewHolder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                equipmentBeans.remove(equipmentBean);
                MyApplication.getMyApplication().getDaoSession().getEquipmentBeanDao().delete(equipmentBean);
                notifyDataSetChanged();
                Toast.makeText(activity, "该设备已删除", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public void setData(List<EquipmentBean> list) {
        this.equipmentBeans.clear();
        if (list != null && list.size() > 0) {
            this.equipmentBeans.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return equipmentBeans.size();
    }

    public static class EquipmentViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private View item;

        public EquipmentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            item = itemView.findViewById(R.id.item);
        }
    }
}
