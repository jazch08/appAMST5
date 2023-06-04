package com.example.appamst5.ui.graphical;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class GraphicalViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public GraphicalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Graphical fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}