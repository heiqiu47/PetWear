package com.example.petwear.ui.my;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;
import com.example.petwear.tool.Utils;

/**
 * 登录
 */
public class MyLoginActivity extends AppCompatActivity {

    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        initView();
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("登录");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //TODO 登录
        mBtnLogin.setOnClickListener(v -> {
            String username = mEditUsername.getText().toString();
            String password = mEditPassword.getText().toString();
            if (username.equals("123456") && password.equals("123456")) {
                SharedPreferences.Editor editor = getSharedPreferences("user",MODE_PRIVATE).edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.putString("name", "西瓜");
                editor.apply();
                Utils.login = 1;
                Toast.makeText(MyLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(MyLoginActivity.this, "账户密码错误，应为123456", Toast.LENGTH_SHORT).show();
            }

        });
        mBtnRegister.setOnClickListener(v -> startActivity(new Intent(MyLoginActivity.this, MyRegisterActivity.class)));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mEditUsername = findViewById(R.id.edit_username);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
    }
}