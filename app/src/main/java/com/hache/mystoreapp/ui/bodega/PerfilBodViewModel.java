package com.hache.mystoreapp.ui.bodega;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilBodViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    /*
    public PerfilBodViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }*/

    public LiveData<String> getText() {
        return mText;
    }
}
