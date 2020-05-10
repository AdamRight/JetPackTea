package com.tea.jetpack.navigationdemo2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by jiangtea on 2020/5/2.
 */
public class ViewModelWithNavigation extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void changeNum(int change) {
        number.setValue(number.getValue() + change);
    }
}
