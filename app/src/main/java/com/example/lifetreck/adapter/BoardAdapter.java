package com.example.lifetreck.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetreck.databinding.ItemBoardBinding;
import com.example.lifetreck.interfeas.ItemClickListener;
import com.example.lifetreck.models.BoardModel;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    ArrayList<BoardModel> list;
    ItemClickListener listener;

    public BoardAdapter(ArrayList<BoardModel> list, ItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BoardAdapter.BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBoardBinding binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext())
                , parent, false);
        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.BoardViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        private ItemBoardBinding binding;

        public BoardViewHolder(ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(BoardModel model) {
           binding.boardImg.setAnimation(model.getAnimation());
            binding.descriptionTv.setText(model.getDescription());
            binding.nextBtn.setText(model.getButtonText());
            binding.nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(getAdapterPosition());

                }
            });

        }
    }
}
