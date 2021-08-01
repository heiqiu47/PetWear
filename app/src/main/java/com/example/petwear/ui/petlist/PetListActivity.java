package com.example.petwear.ui.petlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petwear.R;
import com.example.petwear.adapter.PetListAdapter;
import com.example.petwear.bean.PetBean;
import com.example.petwear.ui.home.PetInfoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * 宠物管理列表
 */
public class PetListActivity extends AppCompatActivity {

    private ListView mListPet;
    private FloatingActionButton mBtnAdd;
    private List<PetBean> petData = new ArrayList<>();
    private PetListAdapter petAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);
        initView();
        //标题栏修改
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("宠物管理");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //加载列表
        setData();
        petAdapter = new PetListAdapter(PetListActivity.this, R.layout.item_pet_list, petData);
        mListPet.setAdapter(petAdapter);
        //TODO 宠物选择
        mListPet.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "未选择成功", Toast.LENGTH_SHORT).show();
            finish();
        });
        //添加宠物
        mBtnAdd.setOnClickListener(v -> startActivity(new Intent(this, PetAddActivity.class)));
    }

    //TODO 加载数据
    private void setData() {
        petData.add(new PetBean(10001, "狗", "狗勾", 1));
        petData.add(new PetBean(10002, "猫", "小杰宝", 0));
        petData.add(new PetBean(10003, "狗", "正义", 1));
        petData.add(new PetBean(10004, "猫", "正义", 0));
        petData.add(new PetBean(10005, "狗", "正义", 1));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mListPet = findViewById(R.id.list_pet);
        mBtnAdd = findViewById(R.id.btn_add);
    }
}