
package com.example.lifetreck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.lifetreck.databinding.FragmentTaskBinding;

public class TaskFragment extends Fragment {
    private FragmentTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        setData();
    }

    private void setData() {
        if (getArguments() != null) {
            String result = getArguments().getString("key");
            binding.tvText.setText(result);
        }
    }


    private void initClickers() {
        binding.applyBtn.setOnClickListener(view -> {
            Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
        });
    }
}
