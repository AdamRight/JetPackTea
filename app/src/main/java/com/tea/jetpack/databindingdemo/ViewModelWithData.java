package com.tea.jetpack.databindingdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * Created by jiangtea on 2020/5/1.
 */
public class ViewModelWithData extends ViewModel {
    private SavedStateHandle handle;
    private String numkey = "NUMKEY";

    /**
     * 代替Activity中的savedInstanceState
     * @param handle
     */
    public ViewModelWithData(SavedStateHandle handle){
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if (!handle.contains(numkey)){
            handle.set(numkey,0);
        }
        return handle.getLiveData(numkey);
    }

    public void add(){
        getNumber().setValue(getNumber().getValue() + 1);
    }

}
