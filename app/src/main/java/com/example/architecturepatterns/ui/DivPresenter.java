package com.example.architecturepatterns.ui;

import com.example.architecturepatterns.pojo.DataBase;

public class DivPresenter {

    DivView view;

    public DivPresenter(DivView view) {
        this.view = view;
    }

    public int getDivResult(){

        return ((new DataBase().getNumbers().getFirstNum()) / (new DataBase().getNumbers().getSecondNum()));

    }

    public void getresult()
    {
        view.onGetDivResult(getDivResult());
    }

}
