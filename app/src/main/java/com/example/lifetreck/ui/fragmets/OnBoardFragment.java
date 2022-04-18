package com.example.lifetreck.ui.fragmets;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.lifetreck.R;
import com.example.lifetreck.adapter.BoardAdapter;
import com.example.lifetreck.databinding.FragmentOnBoardBinding;
import com.example.lifetreck.interfeas.ItemClickListener;
import com.example.lifetreck.models.BoardClient;
import com.example.lifetreck.models.BoardModel;

import java.util.ArrayList;

public class OnBoardFragment extends Fragment implements ItemClickListener {

    FragmentOnBoardBinding binding;
    BoardAdapter adapter;
    ArrayList<BoardModel> list;
    SharedPreferences preferences;
    final String FILE_NAME = "board_file";
    final String IS_SHOW_KEY = "isShow";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkOnShowBoard();
        initAdapter();

    }

    private void checkOnShowBoard() {
        preferences = requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        boolean isShow = preferences.getBoolean(IS_SHOW_KEY, false);
        if (isShow) {
            Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
        }
    }

    private void initAdapter() {
        list = BoardClient.getList();
        adapter = new BoardAdapter(list, this);
        binding.pager.setAdapter(adapter);
        binding.wormDot.setViewPager2(binding.pager);
    }

    @Override
    public void itemClick(int position) {
        if (position == 0 || position == 1) {
            binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);
            preferences = requireActivity().getSharedPreferences("board_file", Context.MODE_PRIVATE);
            preferences.edit().putBoolean("isShow", true).apply();
        } else {
            Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        list.clear();
    }
}
