package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityResetPwdBinding;

/**
 * @author Surface Pro 6
 */
public class ResetPwdActivity extends AppCompatActivity {

    private ActivityResetPwdBinding mBinding;
    String name, sex = "", phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityResetPwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mBinding.editName.getText().toString().trim();
                phone = mBinding.editPhone.getText().toString().trim();
                String toast;
                if ("".equals(name)) {
                    toast = "请填写昵称";
                } else if ("".equals(sex)) {
                    toast = "请选择性别";
                } else if ("".equals(phone)) {
                    toast = "请填写手机号码";
                } else if (phone.length() != 11) {
                    toast = "请使用正确的中国大陆手机号码!";
                } else {
                    SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                    //如果是0，就说明没有找到对应的信息
                    String error="0";
                    String spPhone = sp.getString("phone_" + phone, error);
                    String spName = sp.getString("name_" + phone, error);
                    String spSex = sp.getString("sex_" + phone, error);
                    if (!spPhone.equals(phone)||!spName.equals(name)||!spSex.equals(sex))
                    {
                        toast = "很抱歉，信息不匹配，无法重置密码";
                    } else {
                        //跳转至修改密码界面
                        Intent intent = new Intent(ResetPwdActivity.this,UpdatePwdActivity.class);
                        intent.putExtra("phone",phone);
                        startActivity(intent);
                        toast = "请填写新的密码";
                        finish();
                    }
                }
                Toast.makeText(ResetPwdActivity.this, toast, Toast.LENGTH_LONG).show();
            }
        });

        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_man) {
                    sex = mBinding.radioMan.getText().toString();
                } else {
                    sex = mBinding.radioWomen.getText().toString();
                }
            }
        });
    }
}