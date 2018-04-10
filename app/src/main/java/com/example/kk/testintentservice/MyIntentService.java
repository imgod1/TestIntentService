package com.example.kk.testintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {
    public static final String KEY = "key";

    public MyIntentService() {
        this(null);
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String key = intent.getStringExtra(KEY);
        Log.e("test", "onHandleIntent:收到任务:" + key + " 开始执行");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("test", "onHandleIntent:收到任务:" + key + " 执行结束");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("test", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("test", "onDestroy");
    }
}