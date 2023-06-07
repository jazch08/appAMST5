package com.example.appamst5.ui.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import androidx.core.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.appamst5.databinding.FragmentVideoBinding;

public class VideoFragment extends Fragment {

    private FragmentVideoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VideoViewModel videoViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(VideoViewModel.class);

        binding = FragmentVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVideo;
        videoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}