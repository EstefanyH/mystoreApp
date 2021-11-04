package com.hache.mystoreapp.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilCliViewModel extends ViewModel {
    private MutableLiveData<String> mText;
/*
    public PerfilCliViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }*/

    public LiveData<String> getText() {
        return mText;
    }
}
