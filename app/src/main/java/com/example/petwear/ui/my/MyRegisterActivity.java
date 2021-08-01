package com.example.petwear.ui.my;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;

public class MyRegisterActivity extends AppCompatActivity {

    private EditText mEditUsername;
    private EditText mEditNickName;
    private EditText mEditPhoneNumber;
    private EditText mEditPassword;
    private RadioGroup mGroupSex;
    private RadioButton mRadioSex1;
    private RadioButton mRadioSex0;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_register);
        initView();
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("注册");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //TODO 注册
        mBtnRegister.setOnClickListener(v -> {
            Toast.makeText(MyRegisterActivity.this, "未注册成功", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mEditUsername = findViewById(R.id.edit_username);
        mEditNickName = findViewById(R.id.edit_nick_name);
        mEditPhoneNumber = findViewById(R.id.edit_phone_number);
        mEditPassword = findViewById(R.id.edit_password);
        mGroupSex = findViewById(R.id.group_sex);
        mRadioSex1 = findViewById(R.id.radio_sex_1);
        mRadioSex0 = findViewById(R.id.radio_sex_0);
        mBtnRegister = findViewById(R.id.btn_register);
    }
}