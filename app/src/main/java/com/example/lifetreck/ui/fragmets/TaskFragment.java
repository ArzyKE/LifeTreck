
package com.example.lifetreck.ui.fragmets;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import com.example.lifetreck.App;
import com.example.lifetreck.R;
import com.example.lifetreck.adapter.TaskAdapter;
import com.example.lifetreck.constants.Conctants;
import com.example.lifetreck.databinding.FragmentTaskBinding;
import com.example.lifetreck.interfeas.Listener;
import com.example.lifetreck.models.TaskModel;

public class TaskFragment extends Fragment {

    private FragmentTaskBinding binding;
    private TaskModel taskModel;
    private TaskAdapter taskAdapter = new TaskAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        setData();
        initAdapter1();
        onItemClick();

    }

    private void initAdapter1() {
        binding.recyclerview.setAdapter(taskAdapter);
        App.getApp().getDataBase().taskDao().getListData().observe(getViewLifecycleOwner(), taskModels -> taskAdapter.setList(taskModels));
    }

    private void setData() {
        getParentFragmentManager().setFragmentResultListener(Conctants.KEY, getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                if (bundle.containsKey("text")) {
                    String text = bundle.getString("text");
                    String frequency = bundle.getString("regular");
                    String date = bundle.getString("date");
                    taskModel = new TaskModel(text, frequency, date);
                    App.getApp().getDataBase().taskDao().insert(taskModel);
                }
            }
        });
    }

    private void initClickers() {
        binding.applyBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.createTaskFragment);
            }
        });
    }

    public void onItemClick() {
        taskAdapter.setListener(new Listener() {
            @Override
            public void click(TaskModel model) {
                String setMessage = "Вы уверены, что хотите удалить?";
                String setTitle = "Удалить";
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle(setTitle);
                builder.setMessage(setMessage);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        App.getApp().getDataBase().taskDao().delete(model);
                    }
                })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert).show();
            }
        });
    }
}



