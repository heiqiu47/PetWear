package com.example.petwear.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.petwear.MainActivity;
import com.example.petwear.R;
import com.example.petwear.tool.Utils;
import com.example.petwear.ui.my.MyFeedbackActivity;
import com.example.petwear.ui.my.MyInfoActivity;
import com.example.petwear.ui.my.MyLoginActivity;
import com.example.petwear.ui.my.MyPasswordActivity;
import com.example.petwear.ui.petlist.PetListActivity;

/**
 * 个人中心界面
 */
public class MyFragment extends Fragment {

    private LinearLayout mBtnUser;
    private ImageView mImgUser;
    private TextView mTextName;
    private LinearLayout mBtnInfo;
    private LinearLayout mBtnPetsList;
    private LinearLayout mBtnPassword;
    private LinearLayout mBtnFeedback;
    private Button mBtnUserInOut;

    public MyFragment() {
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        //TODO 登录判断
        isLogin();
        mBtnUser.setOnClickListener(v -> loginStart(MyInfoActivity.class));
        mBtnInfo.setOnClickListener(v -> loginStart(MyInfoActivity.class));
        mBtnPetsList.setOnClickListener(v -> loginStart(PetListActivity.class));
        mBtnPassword.setOnClickListener(v -> loginStart(MyPasswordActivity.class));
        mBtnFeedback.setOnClickListener(v -> loginStart(MyFeedbackActivity.class));
        mBtnUserInOut.setOnClickListener(v -> {
            //退出账号
            if (!isLogin()) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("退出");
                dialog.setMessage("确定要退出吗?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确认", (dialog1, which) -> {
                    Utils.login = 0;
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE).edit();
                    editor.putString("username", "");
                    editor.putString("password", "");
                    editor.apply();
                    Toast.makeText(getActivity(), "已退出", Toast.LENGTH_SHORT).show();
                    mTextName.setText("未登录");
                    mBtnUserInOut.setText("登录");
                });
                dialog.setNegativeButton("取消", (dialog12, which) -> {
                });
                dialog.show();

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Utils.login == 0) {
            mBtnUserInOut.setText("登录");
        } else {
            mBtnUserInOut.setText("退出账号");
            mImgUser.setImageResource(R.drawable.user_girl);
            getInfoData();
        }
    }

    private void getInfoData() {
        SharedPreferences user = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String name = user.getString("name","");
        mTextName.setText(name);
    }

    private void loginStart(Class<?> c) {
        if (!isLogin()) {
            startActivity(new Intent(getActivity(), c));
        }
    }

    private Boolean isLogin() {
        if (Utils.login == 0) {
            Toast.makeText(getActivity(), "尚未登录, 请登录", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), MyLoginActivity.class));
            return true;
        }
        return false;
    }

    private void initView(View view) {
        mBtnUser = view.findViewById(R.id.btn_user);
        mImgUser = view.findViewById(R.id.img_user);
        mTextName = view.findViewById(R.id.text_name);
        mBtnInfo = view.findViewById(R.id.btn_info);
        mBtnPetsList = view.findViewById(R.id.btn_pets_list);
        mBtnPassword = view.findViewById(R.id.btn_password);
        mBtnFeedback = view.findViewById(R.id.btn_feedback);
        mBtnUserInOut = view.findViewById(R.id.btn_user_in_out);
    }
}