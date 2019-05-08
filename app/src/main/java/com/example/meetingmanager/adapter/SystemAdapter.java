package com.example.meetingmanager.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.bean.MeetingBean;
import com.example.meetingmanager.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统管理
 */
public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.SystemViewHolder> {

    private List<UserBean> userBeans = new ArrayList<>();
    private Activity activity;

    public SystemAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public SystemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SystemViewHolder(activity.getLayoutInflater().inflate(R.layout.item_system, null));
    }

    @Override
    public void onBindViewHolder(@NonNull SystemViewHolder systemViewHolder, int pos) {
        final UserBean userBean = userBeans.get(pos);
        systemViewHolder.name.setText("用户名称：" + userBean.getUserName());
        if (userBean.type == 0) {
            systemViewHolder.rb01.setChecked(true);
        } else {
            systemViewHolder.rb02.setChecked(true);
        }
        systemViewHolder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                userBeans.remove(userBean);
                MyApplication.getMyApplication().getDaoSession().getUserBeanDao().delete(userBean);
                notifyDataSetChanged();
                Toast.makeText(activity, "删除该用户成功", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        systemViewHolder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.rb01:
                        userBean.type = 0;
                        Toast.makeText(activity, "修改用户权限成功", Toast.LENGTH_SHORT).show();
                        MyApplication.getMyApplication().getDaoSession().getUserBeanDao().update(userBean);
                        break;
                    case R.id.rb02:
                        userBean.type = 1;
                        Toast.makeText(activity, "修改用户权限成功", Toast.LENGTH_SHORT).show();
                        MyApplication.getMyApplication().getDaoSession().getUserBeanDao().update(userBean);
                        break;
                }
            }
        });
    }

    public void setData(List<UserBean> list) {
        this.userBeans.clear();
        if (list != null && list.size() > 0) {
            this.userBeans.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userBeans.size();
    }

    public static class SystemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private RadioButton rb01;
        private RadioButton rb02;
        private RadioGroup rg;
        private ViewGroup item;


        public SystemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            rb01 = itemView.findViewById(R.id.rb01);
            rb02 = itemView.findViewById(R.id.rb02);
            rg = itemView.findViewById(R.id.rg);
            item = itemView.findViewById(R.id.item);
        }
    }
}
