package com.example.lifetreck.ui.fragmets;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifetreck.R;
import com.example.lifetreck.constants.Conctants;
import com.example.lifetreck.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class CreateTaskFragment extends BottomSheetDialogFragment {

    private FragmentCreateTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListener();
    }

    private void setupListener() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = binding.textEt.getText().toString();
                String date = binding.dataBtn.getText().toString();
                String frequency = binding.regularBtn.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("text", title);
                bundle.putString("date", date);
                bundle.putString("regular", frequency);
                getParentFragmentManager().setFragmentResult(Conctants.KEY, bundle);
                dismiss();
            }
        });

        binding.dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog().show();
            }
        });
        binding.regularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public DatePickerDialog datePickerDialog() {
        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog startTime = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                if (monthOfYear < 10) {
                    int month = monthOfYear + 1;
                    binding.dataBtn.setText(dayOfMonth + ".0" + month + "." + year);

                }
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        return startTime;
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(requireActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.regular_dialog);
        RadioButton day = (RadioButton) dialog.findViewById(R.id.once_a_day);
        RadioButton week = (RadioButton) dialog.findViewById(R.id.once_a_year);
        RadioButton month = (RadioButton) dialog.findViewById(R.id.once_a_month);
        RadioButton year = (RadioButton) dialog.findViewById(R.id.once_a_week);
        TextView cancel = (TextView) dialog.findViewById(R.id.once_a_day);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.regularBtn.setText(day.getText().toString());
            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.regularBtn.setText(week.getText().toString());
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.regularBtn.setText(month.getText().toString());
            }
        });
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.regularBtn.setText(year.getText().toString());
            }
        });

        dialog.show();
    }


}