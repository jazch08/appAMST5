package com.example.appamst5.ui.video;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class VideoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VideoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is video fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}