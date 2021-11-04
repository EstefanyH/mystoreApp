package com.hache.mystoreapp.ui.bodega;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductoBodViewModel extends ViewModel {
    private MutableLiveData<String> mText;


    public LiveData<String> getText() {
        return mText;
    }
}
