package com.example.meetingmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meetingmanager.R;

public class SystemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        setTitle("系统管理");
    }
}
