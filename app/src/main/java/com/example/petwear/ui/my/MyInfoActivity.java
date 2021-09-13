package com.example.petwear.ui.my;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;

public class MyInfoActivity extends AppCompatActivity {

    private ImageView mImgUser;
    private RadioGroup mGroupSex;
    private RadioButton mRadioSex1;
    private RadioButton mRadioSex0;
    private EditText mEditName;
    private EditText mEditPhone;
    private TextView mTextUsername;
    private TextView mTextUserTime;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        initView();

        mRadioSex0.setChecked(true);
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("个人信息");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //TODO 修改个人信息
        mButton.setOnClickListener(v -> {
            Toast.makeText(MyInfoActivity.this, "未修改成功", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mImgUser = findViewById(R.id.img_user);
        mGroupSex = findViewById(R.id.group_sex);
        mRadioSex1 = findViewById(R.id.radio_sex_1);
        mRadioSex0 = findViewById(R.id.radio_sex_0);
        mEditName = findViewById(R.id.edit_name);
        mEditPhone = findViewById(R.id.edit_phone);
        mTextUsername = findViewById(R.id.text_username);
        mTextUserTime = findViewById(R.id.text_user_time);
        mButton = findViewById(R.id.button);
    }
}