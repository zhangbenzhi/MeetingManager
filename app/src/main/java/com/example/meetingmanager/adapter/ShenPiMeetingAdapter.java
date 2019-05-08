package com.example.meetingmanager.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.meetingmanager.R;
import com.example.meetingmanager.activity.MeetingDetailActivity;
import com.example.meetingmanager.bean.MeetingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 待审批
 */
public class ShenPiMeetingAdapter extends RecyclerView.Adapter<ShenPiMeetingAdapter.MeetingViewHolder> {

    private List<MeetingBean> meetingBeans = new ArrayList<>();
    private Activity activity;

    public ShenPiMeetingAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MeetingViewHolder(activity.getLayoutInflater().inflate(R.layout.item_shenpi_meeting, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder meetingViewHolder, int i) {
        MeetingBean meetingBean = meetingBeans.get(i);
        meetingViewHolder.name.setText(meetingBean.getMettingName());
        meetingViewHolder.btnShenpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meetingBean.setIsOk(true);
                meetingBeans.remove(i);
                notifyDataSetChanged();
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
        private Button btnShenpi;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            item = itemView.findViewById(R.id.item);
            btnShenpi = itemView.findViewById(R.id.btn_shenpi);
        }
    }
}
