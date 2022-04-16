package com.example.lifetreck.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetreck.databinding.ItemListBinding;
import com.example.lifetreck.interfeas.ItemClickListener;
import com.example.lifetreck.models.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHoder> {
    private ArrayList<TaskModel> models = new ArrayList<>();

    public TaskAdapter(ArrayList<TaskModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TaskAdapter.TaskHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TaskAdapter.TaskHoder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskHoder holder, int position) {
        holder.onBind(models.get(position));
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setData(TaskModel taskModel) {
        this.models.add(taskModel);
        notifyDataSetChanged();
    }

    public class TaskHoder extends RecyclerView.ViewHolder {
        private final ItemListBinding binding;

        public TaskHoder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void onBind(TaskModel taskModel) {
            binding.tvText.setText(taskModel.getTitle());
            binding.tvCalendar.setText(taskModel.getDate());
            binding.tvRegular.setText(taskModel.getRegular());

        }
    }
}
