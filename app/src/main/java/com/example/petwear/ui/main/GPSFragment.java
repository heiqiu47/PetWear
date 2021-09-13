package com.example.petwear.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petwear.R;
import com.example.petwear.ui.petlist.PetListActivity;


/**
 * GPS 界面
 */
public class GPSFragment extends Fragment {
    private MapView mBMapView;
    private LinearLayout mBtnPets;
    private ImageView mPetImg;
    private TextView mPetName;

    public GPSFragment() {
        // Required empty public constructor
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g_p_s, container, false);
        initView(view);
        Glide.with(getContext()).load(R.drawable.dog)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mPetImg);
        //TODO 宠物切换
        mBtnPets.setOnClickListener(v -> startActivity(new Intent(getContext(), PetListActivity.class)));
        //TODO 定位
        BaiduMap mBaiduMap = mBMapView.getMap();
        //定义Maker坐标点
        LatLng point = new LatLng(22.90026, 112.89262);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_markb);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap)
                .zIndex(9)// 設置marker的所在層級
                .draggable(true);// 设置手势拖拽
        //在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);

        MapStatus mMapStatus = new MapStatus.Builder()
                .target(point)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mBMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mBMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mBMapView.onDestroy();
    }

    private void initView(View view) {
        mBMapView = view.findViewById(R.id.bMapView);
        mBtnPets = view.findViewById(R.id.btn_pets);
        mPetImg = view.findViewById(R.id.pet_img);
        mPetName = view.findViewById(R.id.pet_name);
    }
}