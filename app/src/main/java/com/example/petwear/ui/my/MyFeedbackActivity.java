package com.example.petwear.ui.my;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;

public class MyFeedbackActivity extends AppCompatActivity {

    private EditText mEditFeedback;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_feedback);
        initView();
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("意见反馈");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        // TODO 意见反馈
        mButton.setOnClickListener(v -> {
            Toast.makeText(MyFeedbackActivity.this, "未反馈成功", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mEditFeedback = findViewById(R.id.edit_feedback);
        mButton = findViewById(R.id.button);
    }
}