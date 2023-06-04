package com.example.appamst5.ui.gallery;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CalendarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CalendarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}