package com.example.petwear.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petwear.R;
import com.example.petwear.model.PetBean;
import com.example.petwear.tool.Utils;

import java.util.List;


public class PetListAdapter extends ArrayAdapter<PetBean> {

    public PetListAdapter(@NonNull Context context, int resource, @NonNull List<PetBean> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pet_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mPetImg = convertView.findViewById(R.id.pet_img);
            viewHolder.mPetName = convertView.findViewById(R.id.pet_name);
            viewHolder.mPetSex = convertView.findViewById(R.id.pet_sex);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PetBean item = getItem(position);
        Glide.with(getContext()).load(Utils.getPetImg(item.getPetType()))
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHolder.mPetImg);
        viewHolder.mPetName.setText(item.getPetName());
        viewHolder.mPetSex.setText(item.getPetSex() == 0 ? "雌" : "雄");
        return convertView;
    }

    private class ViewHolder {
        private ImageView mPetImg;
        private TextView mPetName;
        private TextView mPetSex;
    }
}

