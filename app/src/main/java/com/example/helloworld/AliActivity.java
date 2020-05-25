package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class AliActivity extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {//在创建Activity的时候调用该方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);//强制横屏，且只能横屏的旋转，如果此处标红并非代码错误，可消除警告
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.app_name),Toast.LENGTH_LONG).show();
        //Toast，弹出式通知
        //makeText()，构建通知,三个参数(Context,字符串资源,时长)
        //Context，上下文
        //getApplicationContext()，获取当前Context
        //show()，显示出来
        //getResources().getString()，获取资源.获取字符串资源（资源ID）
    }
}
