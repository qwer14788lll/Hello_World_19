package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent：意图分为显示和隐式
                //new Intent的参数上下文，目标activity的类
                //默认手机号码10086，默认密码123456
                String phone=mBinding.editPhone.getText().toString();
                String pwd=mBinding.editPwd.getText().toString();
                SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                String temp_phone=sp.getString("phone_" + phone,"error");
                String temp_pwd=sp.getString("pwd_" + phone,"error");
                if(phone.equals(temp_phone)&&pwd.equals(temp_pwd))
                {
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("data_phone",phone);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,"手机号或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });

        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
