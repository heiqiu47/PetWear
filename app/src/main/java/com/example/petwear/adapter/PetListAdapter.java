package com.example.petwear.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.petwear.R;
import com.example.petwear.model.PetBean;
import com.example.petwear.tool.Utils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
        viewHolder.mPetImg.setImageResource(Utils.getPetImg(item.getPetType()));
        viewHolder.mPetName.setText(item.getPetName());
        viewHolder.mPetSex.setText(item.getPetSex() == 0 ? "雌" : "雄");
        return convertView;
    }

    private class ViewHolder {
        private CircleImageView mPetImg;
        private TextView mPetName;
        private TextView mPetSex;
    }
}

