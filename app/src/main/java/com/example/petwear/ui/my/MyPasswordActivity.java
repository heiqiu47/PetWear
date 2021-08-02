package com.example.petwear.ui.my;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;

/**
 * 密码修改
 */
public class MyPasswordActivity extends AppCompatActivity {

    private EditText mEditPasswordOld;
    private EditText mEditPasswordNew;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_password);
        initView();
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("密码修改");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //TODO 修改密码
        mButton.setOnClickListener(v -> {
            Toast.makeText(MyPasswordActivity.this, "未修改成功", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mEditPasswordOld = findViewById(R.id.edit_password_old);
        mEditPasswordNew = findViewById(R.id.edit_password_new);
        mButton = findViewById(R.id.button);
    }
}