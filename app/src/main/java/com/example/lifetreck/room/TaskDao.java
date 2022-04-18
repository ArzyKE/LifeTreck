package com.example.lifetreck.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lifetreck.models.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(TaskModel taskModel);

    @Delete
    void delete(TaskModel taskModel);

    @Query("SELECT * FROM task_model")
    LiveData<List<TaskModel>> getListData();
}
