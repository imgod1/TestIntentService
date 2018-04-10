package com.example.kk.testintentservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 2018年4月10日 21:33:41
 * 同样的代码 使用内部类的IntentSrvice就会崩溃
 * 1.IntentService 虽然即用即走 但是千万记得在配置文件中注册
 * 2.IntentService/Service 不能作为内部类
 * 3.Service 运行在主线程 运行耗时操作会ANR, IntentService运行在子线程
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCLick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_my_intent_service:
                startMyIntentService("imgod");
                break;
            case R.id.btn_start_my_service:
                startMyService("imgod");
                break;
        }
    }

    public void startMyIntentService(String content) {
        Intent intent = new Intent(MainActivity.this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY, content);
        startService(intent);
    }

    public void startMyService(String content) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra(MyIntentService.KEY, content);
        startService(intent);
    }


}
