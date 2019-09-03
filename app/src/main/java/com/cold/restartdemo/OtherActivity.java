package com.cold.restartdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OtherActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = findViewById(R.id.tv_test);
        tvTest.setText("other activity");
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartWelcome(OtherActivity.this);
            }
        });
    }

    /**
     * 打开欢迎页面
     */
    public void restartWelcome(Activity activity) {
        Intent i = activity.getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(activity.getBaseContext().getPackageName());
        if (i != null) {
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // 将整个任务栈清空
            activity.startActivity(i);
        }
    }
}
