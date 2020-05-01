package com.tea.jetpack.livedatademo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by jiangtea on 2020/5/1.
 */
public class LiveModelWithData extends ViewModel {
    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum() {
        if (num == null){
            num = new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void changeNum(int change){
        num.setValue(num.getValue() + change);
    }
}
