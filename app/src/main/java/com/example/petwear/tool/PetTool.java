package com.example.petwear.tool;

import com.example.petwear.R;

public class PetTool {
    public static int getPetImg(String petType) {
        int i = 0;
        switch (petType) {
            case "猫":
                i = R.drawable.cat;
                break;
            case "狗":
                i = R.drawable.dog;
                break;
        }
        return i;
    }
}
