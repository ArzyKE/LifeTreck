package com.example.lifetreck.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetreck.databinding.ItemListBinding;
import com.example.lifetreck.interfeas.Listener;
import com.example.lifetreck.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHoder> {

    private List<TaskModel> models = new ArrayList<>();
    private Listener listener;

    public void setList(List<TaskModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
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

    public class TaskHoder extends RecyclerView.ViewHolder {
        private ItemListBinding binding;

        public TaskHoder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TaskModel taskModel) {
            binding.tvText.setText(taskModel.getTitle());
            binding.tvCalendar.setText(taskModel.getDate());
            binding.tvRegular.setText(taskModel.getRegular());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.click(taskModel);
                }
            });
        }
    }
}
