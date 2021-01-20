package com.example.architecturepatterns.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architecturepatterns.pojo.DataBase;

public class MulViewModel extends ViewModel {

    public MutableLiveData<String> mulResultMutableLiveData = new MutableLiveData<>();

    public void getResultOfMul() {

        String result = getMulResult() + "";
        mulResultMutableLiveData.setValue(result);

    }

    private int getMulResult() {

        return ((new DataBase().getNumbers().getFirstNum()) * (new DataBase().getNumbers().getSecondNum()));

    }
}
