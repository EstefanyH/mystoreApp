package com.hache.mystoreapp.ui.repartidor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PedidoRepViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PedidoRepViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
