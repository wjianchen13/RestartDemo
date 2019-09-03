package com.cold.restartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "WelcomeActivity";
    private ImageView imgvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imgvWelcome = findViewById(R.id.imgv_welcome);
        printInfo();
//        if(!isTaskRoot()) {
//            finish();
//            return;
//        }

        imgvWelcome.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        }, 500);

    }

    private void printInfo() {
        log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log("flag: " +  getFlag());
        log("taskId: " + getTaskId());
        log("Pid: " + android.os.Process.myPid());
    }

    private void log(String info) {
        Log.e(TAG, "==========================> printInfo: " + info);
    }

    private String getFlag() {
        String flag = "";
        if((getIntent().getFlags() & Intent.FLAG_ACTIVITY_NEW_TASK) != 0) {
            flag += "Intent.FLAG_ACTIVITY_NEW_TASK ";
        }
        if((getIntent().getFlags() & Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED) != 0) {
            flag += "Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED ";
        }

        if((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            flag += "Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT ";
        }
        return flag;
    }

    @Override
    protected void onStart() {
        log("onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        log("onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        log("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        log("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        log("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        log("onDestroy");
        super.onDestroy();

    }
}

