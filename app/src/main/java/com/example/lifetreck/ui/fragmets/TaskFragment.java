
package com.example.lifetreck.ui.fragmets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import com.example.lifetreck.R;
import com.example.lifetreck.adapter.TaskAdapter;
import com.example.lifetreck.constants.Conctants;
import com.example.lifetreck.databinding.FragmentTaskBinding;
import com.example.lifetreck.models.TaskModel;

import java.util.ArrayList;

public class TaskFragment extends Fragment {

    private FragmentTaskBinding binding;
    private ArrayList<TaskModel> list = new ArrayList<>();
    TaskAdapter taskAdapter = new TaskAdapter(list);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        initAdapter();
        setData();


    }

    private void initAdapter() {
        binding.recyclerview.setAdapter(taskAdapter);
    }

    private void setData() {
        getParentFragmentManager().setFragmentResultListener(Conctants.KEY, getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                if (bundle.containsKey("text")) {
                    String text = bundle.getString("text");
                    String frequency = bundle.getString("regular");
                    String date = bundle.getString("date");
                    TaskModel taskModel = new TaskModel(text, frequency, date);
                   // list.add(new TaskModel(text, frequency, date));
                    taskAdapter.setData(taskModel);
                    //taskAdapter.notifyItemInserted(list.size() + 1);
                }

            }
        });


    }

    private void initClickers() {
        binding.applyBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.createTaskFragment);
                //CreateTaskFragment createTaskFragment = new CreateTaskFragment();
               // createTaskFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });
//        binding.applyBtnOne.setOnClickListener(view -> {
//            new CreateTaskFragment().show(requireActivity().getSupportFragmentManager(), "");
//
//        });
    }
}
