package com.example.lifetreck.models;

import com.example.lifetreck.R;

import java.util.ArrayList;

public class BoardClient {
    public static ArrayList<BoardModel> list = new ArrayList<>();

    public static ArrayList<BoardModel> getList() {
        list.add(new BoardModel(R.drawable.nmae, "Экономь время", "Дальше "));
        list.add(new BoardModel(R.drawable.image1, "Достигай целей", "Дальше "));
        list.add(new BoardModel(R.drawable.image2, "Развивайся", "Начинаем"));
        return list;
    }
}
