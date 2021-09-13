package com.example.petwear.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petwear.R;
import com.example.petwear.ui.home.PetInfoActivity;
import com.example.petwear.ui.petlist.PetListActivity;

/**
 * 主界面
 */
public class HomeFragment extends Fragment {


    private SwipeRefreshLayout mSwipeRefresh;
    private LinearLayout mPetInfo;
    private ImageView mPetImg;
    private TextView mPetName;
    private LinearLayout mBtnTest;

    public HomeFragment() {
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        setData();
        //TODO 刷新
        mSwipeRefresh.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefresh.setOnRefreshListener(() -> refreshFruits());
        //点击宠物跳转至修改信息界面
        LinearLayout petInfo = view.findViewById(R.id.pet_info);
        petInfo.setOnClickListener(v -> startActivity(new Intent(getContext(), PetInfoActivity.class)));
        return view;
    }

    private void initView(View view) {
        mSwipeRefresh = view.findViewById(R.id.swipe_refresh);
        mPetInfo = view.findViewById(R.id.pet_info);
        mPetImg = view.findViewById(R.id.pet_img);
        mPetName = view.findViewById(R.id.pet_name);
        mBtnTest = view.findViewById(R.id.btn_test);
    }

    //TODO 加载数据
    private void setData() {
        //加载图片
        Glide.with(getContext()).load(R.drawable.cat)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mPetImg);
    }


    //下拉刷新
    private void refreshFruits() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getActivity().runOnUiThread(() -> {
                Toast.makeText(getActivity(), "刷新失败", Toast.LENGTH_SHORT).show();
                mSwipeRefresh.setRefreshing(false);
            });
        }).start();
    }


    //设置菜单
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    //加载菜单布局
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.change_menu, menu);
    }

    //设置菜单功能
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.change) {//监听菜单按钮
            startActivity(new Intent(getContext(), PetListActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}