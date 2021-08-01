package com.example.petwear.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.petwear.R;
import com.example.petwear.ui.my.MyFeedbackActivity;
import com.example.petwear.ui.my.MyLoginActivity;

/**
 * 个人中心界面
 */
public class MyFragment extends Fragment {

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
        mBtnFeedback.setOnClickListener(v -> startActivity(new Intent(getActivity(), MyFeedbackActivity.class)));
        mBtnUserInOut.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MyLoginActivity.class));
        });
        return view;
    }

    private void initView(View view) {
        mImgUser = view.findViewById(R.id.img_user);
        mTextName = view.findViewById(R.id.text_name);
        mBtnInfo = view.findViewById(R.id.btn_info);
        mBtnPetsList = view.findViewById(R.id.btn_pets_list);
        mBtnPassword = view.findViewById(R.id.btn_password);
        mBtnFeedback = view.findViewById(R.id.btn_feedback);
        mBtnUserInOut = view.findViewById(R.id.btn_user_in_out);
    }
}