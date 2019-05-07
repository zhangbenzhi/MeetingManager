package com.example.meetingmanager.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meetingmanager.MyApplication;
import com.example.meetingmanager.R;
import com.example.meetingmanager.activity.MeetingDetailActivity;
import com.example.meetingmanager.bean.MeetingBean;

import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {

    private List<MeetingBean> meetingBeans = new ArrayList<>();
    private Activity activity;

    public MeetingAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MeetingViewHolder(activity.getLayoutInflater().inflate(R.layout.item_meeting, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder meetingViewHolder, int i) {
        MeetingBean meetingBean = meetingBeans.get(i);
        meetingViewHolder.name.setText(meetingBean.getMettingName());
        meetingViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, MeetingDetailActivity.class));
            }
        });
    }

    public void setData(List<MeetingBean> list) {
        this.meetingBeans.clear();
        if (list != null && list.size() > 0) {
            this.meetingBeans.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return meetingBeans.size();
    }

    public static class MeetingViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private View item;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            item = itemView.findViewById(R.id.item);
        }
    }
}
