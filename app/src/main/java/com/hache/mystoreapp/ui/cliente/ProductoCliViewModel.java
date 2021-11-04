package com.hache.mystoreapp.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductoCliViewModel extends ViewModel {
    private MutableLiveData<String> mText;



    public LiveData<String> getText() {
        return mText;
    }
}
