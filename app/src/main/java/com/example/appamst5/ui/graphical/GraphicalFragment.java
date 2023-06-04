package com.example.appamst5.ui.graphical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.appamst5.databinding.FragmentGraphicalBinding;

public class GraphicalFragment extends Fragment {

    private FragmentGraphicalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GraphicalViewModel graphicalViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(GraphicalViewModel.class);

        binding = FragmentGraphicalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGraphical;
        graphicalViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}