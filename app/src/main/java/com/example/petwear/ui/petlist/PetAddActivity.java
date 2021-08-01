package com.example.petwear.ui.petlist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;
import com.example.petwear.tool.PetTool;

public class PetAddActivity extends AppCompatActivity {

    private String petType = "";
    private ImageView mImgPet;
    private RadioGroup mGroupSex;
    private RadioButton mRadioSex0;
    private RadioButton mRadioSex1;
    private EditText mEditPetName;
    private EditText mEditPetNumber;
    private Button mBrnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_add);
        initView();
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("添加宠物");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //切换宠物类型（设置图片）
        final String[] items = {"猫", "狗"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(PetAddActivity.this);
        listDialog.setTitle("选择宠物类型");
        listDialog.setItems(items, (dialog, which) -> {
            petType = items[which];
            mImgPet.setImageResource(PetTool.getPetImg(petType));
        });
        mImgPet.setOnClickListener(v -> listDialog.show());
        //TODO 添加宠物数据
        mBrnAdd.setOnClickListener(v -> {
            Toast.makeText(PetAddActivity.this, "未添加成功", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mImgPet = findViewById(R.id.img_pet);
        mGroupSex = findViewById(R.id.group_sex);
        mRadioSex0 = findViewById(R.id.radio_sex_0);
        mRadioSex1 = findViewById(R.id.radio_sex_1);
        mEditPetName = findViewById(R.id.edit_pet_name);
        mEditPetNumber = findViewById(R.id.edit_pet_number);
        mBrnAdd = findViewById(R.id.brn_add);
    }
}