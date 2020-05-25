package com.example.helloworld;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UIActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButtonLeft, mButtonRight, mButtonOk;
    private Switch mSwitch;
    private ProgressBar mProgressBar;
    private EditText mEditNumber;
    private RadioGroup mRadioGroup;
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private CheckBox mCheckBoxAndroid, mCheckBoxJava, mCheckBoxSQL;
    private RatingBar mRatingBar;
    private String mAndroid = "", mJava = "", mSQL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_i);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏

        mTextView = findViewById(R.id.text_view);
        mButtonLeft = findViewById(R.id.button_left);
        mButtonRight = findViewById(R.id.button_right);
        mButtonOk = findViewById(R.id.button_ok);
        mSwitch = findViewById(R.id.button_switch);
        mProgressBar = findViewById(R.id.progress_bar);
        mEditNumber = findViewById(R.id.edit_number);
        mRadioGroup = findViewById(R.id.radio_group);
        mImageView = findViewById(R.id.image_view);
        mSeekBar = findViewById(R.id.seek_bar);
        mCheckBoxAndroid = findViewById(R.id.check_android);
        mCheckBoxJava = findViewById(R.id.check_java);
        mCheckBoxSQL = findViewById(R.id.check_sql);
        mRatingBar = findViewById(R.id.rating_bar);

        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(R.string.button_left);
            }
        });

        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(R.string.button_right);
            }
        });

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTextView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
            }
        });

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEditNumber.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    s = "0";
                }
                mProgressBar.setProgress(Integer.parseInt(s));
            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_android:
                        mImageView.setImageResource(R.drawable.android);
                        break;
                    case R.id.radio_apple:
                        mImageView.setImageResource(R.drawable.apple);
                        break;
                }
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //当滑块的数值改变时调用
                if (fromUser)//如果是用户行为触发的,才作相应操作
                {
                    mTextView.setText(String.valueOf(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //当用户开始滑动滑块时调用该方法（即触摸时调用一次）
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //当用户结束对滑块滑动时,调用该方法（即触摸结束时调用）
            }
        });

        mCheckBoxAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mAndroid = isChecked ? getResources().getString(R.string.logo) : "";
                mTextView.setText(mAndroid + mJava + mSQL);
                ;
            }
        });

        mCheckBoxJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mJava = isChecked ? getResources().getString(R.string.java) : "";
                mTextView.setText(mAndroid + mJava + mSQL);
            }
        });

        mCheckBoxSQL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSQL = isChecked ? getResources().getString(R.string.sql) : "";
                mTextView.setText(mAndroid + mJava + mSQL);
            }
        });

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {//rating星星数量
                Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.appraise), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
