package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding mBinding;
    String name, sex = "", pwd, pwdOk, phone;
    boolean sms, protocol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mBinding.editName.getText().toString().trim();
                pwd = mBinding.editPwd.getText().toString().trim();
                pwdOk = mBinding.editPwdOk.getText().toString().trim();
                phone = mBinding.editPhone.getText().toString().trim();
                sms = mBinding.switchSms.isChecked();
                protocol = mBinding.checkProtocol.isChecked();
                String toast;
                if (name.equals("")) {
                    toast = "请填写昵称";
                }  else if (sex.equals("")) {
                    toast = "请选择性别";
                } else if (pwd.length() != 6) {
                    toast = "密码长度必须为6位";
                } else if (!pwd.equals(pwdOk)) {
                    toast = "请确保两次输入密码一致";
                } else if (phone.equals("")) {
                    toast = "请填写手机号码";
                }else if (phone.length() != 11) {
                    toast = "请使用正确的中国大陆手机号码!";
                } else if (!protocol) {
                    toast = "请同意本软件的相关协议和策略，否则无法注册！";
                } else {
                    //存储该用户的注册数据
                    toast = "注册成功";
                    //跳转至登录界面
                }
                Toast.makeText(RegisterActivity.this, toast, Toast.LENGTH_LONG).show();
            }
        });

        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_man) {
                    sex = mBinding.radioMan.getText().toString();
                } else sex = mBinding.radioWomen.getText().toString();
            }
        });
    }
}
