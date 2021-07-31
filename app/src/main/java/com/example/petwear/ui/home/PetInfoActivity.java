package com.example.petwear.ui.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;

/**
 * 宠物信息修改
 */
public class PetInfoActivity extends AppCompatActivity {

    private ImageView mPetImg;
    private RadioGroup mSexGroup;
    private RadioButton mSex0Radio;
    private RadioButton mSex1Radio;
    private EditText mPetNameEdit;
    private TextView mPetNumber;
    private Button mBrnUpdate;
    private Button mBtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);
        initView();
        mSex0Radio.setChecked(true);
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("信息修改");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //TODO 修改宠物消息
        mBrnUpdate.setOnClickListener(v -> {
            Toast.makeText(this, "未保存成功", Toast.LENGTH_SHORT).show();
            finish();
        });
        //TODO 删除宠物
        mBtnDelete.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("删除警告");
            dialog.setMessage("确定要删除该宠物吗?");
            dialog.setCancelable(false);
            dialog.setPositiveButton("确认", (dialog1, which) -> {
                Toast.makeText(this, "未删除成功", Toast.LENGTH_SHORT).show();
                finish();
            });
            dialog.setNegativeButton("取消", (dialog12, which) -> {
            });
            dialog.show();
        });

    }

    private void initView() {
        mPetImg = findViewById(R.id.pet_img);
        mSexGroup = findViewById(R.id.sex_group);
        mSex0Radio = findViewById(R.id.sex_0_radio);
        mSex1Radio = findViewById(R.id.sex_1_radio);
        mPetNameEdit = findViewById(R.id.pet_name_edit);
        mPetNumber = findViewById(R.id.pet_number);
        mBrnUpdate = findViewById(R.id.brn_update);
        mBtnDelete = findViewById(R.id.btn_delete);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}