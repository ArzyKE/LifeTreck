package com.example.lifetreck.models;

import com.example.lifetreck.R;
//shitcode

import java.util.ArrayList;

public class BoardClient {
    public static ArrayList<BoardModel> list = new ArrayList<>();

    public static ArrayList<BoardModel> getList() {
        list.add(new BoardModel("tame.json", "Экономь время", "Дальше "));
        list.add(new BoardModel("tame2.json", "Достигай целей", "Дальше "));
        list.add(new BoardModel("tame3.json", "Развивайся", "Начинаем"));
        return list;
    }
}
