package com.hache.mystoreapp.ui.repartidor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistorialRepViewModel extends ViewModel {
    private MutableLiveData<String> mText;



    public LiveData<String> getText() {
        return mText;
    }
}
