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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petwear.R;
import com.example.petwear.tool.Utils;

/**
 * 宠物信息修改
 */
public class PetInfoActivity extends AppCompatActivity {

    private ImageView mPetImg;
    private RadioGroup mGroupSex;
    private RadioButton mRadioSex0;
    private RadioButton mRadioSex1;
    private EditText mPetNameEdit;
    private TextView mPetNumber;
    private Button mBrnUpdate;
    private Button mBtnDelete;
    private String petType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);
        initView();
        Glide.with(this).load(R.drawable.dog)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mPetImg);
        mRadioSex0.setChecked(true);
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("信息修改");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //切换宠物类型（设置图片）
        final String[] items = {"猫", "狗"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(PetInfoActivity.this);
        listDialog.setTitle("选择宠物类型");
        listDialog.setItems(items, (dialog, which) -> {
            petType = items[which];
//            mPetImg.setImageResource(Utils.getPetImg(petType));
            Glide.with(this).load(Utils.getPetImg(petType))
                    .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mPetImg);
        });
        mPetImg.setOnClickListener(v -> listDialog.show());


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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mPetImg = findViewById(R.id.pet_img);
        mGroupSex = findViewById(R.id.group_sex);
        mRadioSex0 = findViewById(R.id.radio_sex_0);
        mRadioSex1 = findViewById(R.id.radio_sex_1);
        mPetNameEdit = findViewById(R.id.pet_name_edit);
        mPetNumber = findViewById(R.id.pet_number);
        mBrnUpdate = findViewById(R.id.brn_update);
        mBtnDelete = findViewById(R.id.btn_delete);
    }
}