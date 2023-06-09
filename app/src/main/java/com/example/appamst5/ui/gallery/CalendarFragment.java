package com.example.appamst5.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appamst5.databinding.FragmentCalendarBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding binding;
    private CalendarView calendarView;
    private EditText editText;
    private TextView listadoEventos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalendarViewModel calendarViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CalendarViewModel.class);

        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarEventos(v);
            }
        });
        //root.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        guardarEventos(v);
        //    }
        //});

        calendarView = binding.calendarView2;
        editText = binding.editTextText2;
        listadoEventos = binding.listEvents;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void guardarEventos(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calendarView.getDate()));
        Log.d("Fecha",selectedDate);
        CharSequence addStr = editText.getText().toString() + " - " + selectedDate + "\n";
        listadoEventos.append(addStr);
    }
}