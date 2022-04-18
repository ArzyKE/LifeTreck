package com.example.lifetreck.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lifetreck.models.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
