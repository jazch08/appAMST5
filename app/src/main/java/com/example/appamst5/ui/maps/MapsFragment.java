package com.example.appamst5.ui.maps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import androidx.core.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.appamst5.databinding.FragmentMapsBinding;

public class MapsFragment extends Fragment {

    private FragmentMapsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapsViewModel mapsViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MapsViewModel.class);

        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMaps;
        mapsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}