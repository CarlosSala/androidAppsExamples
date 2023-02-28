package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

public class SumViewModel extends ViewModel {

    // result for defect is 0
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
