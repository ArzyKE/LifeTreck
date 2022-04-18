package com.example.lifetreck.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_model")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String regular;
    private String date;

    public TaskModel(String title, String regular, String date) {
        this.title = title;
        this.regular = regular;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRegular() {
        return regular;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

}
