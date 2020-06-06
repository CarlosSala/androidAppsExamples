package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

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
