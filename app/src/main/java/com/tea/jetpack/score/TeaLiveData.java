package com.tea.jetpack.score;

import android.util.Log;

import androidx.lifecycle.LiveData;

/**
 * Created by jiangtea on 2020/4/19.
 */
public class TeaLiveData extends LiveData<Integer> {

    @Override
    protected void onActive() {
        Log.d(ScoreActivity.Tag,"LiveData:onActive");
    }

    @Override
    protected void onInactive() {
        Log.d(ScoreActivity.Tag,"LiveData:onInactive");
    }

    /**
     * 由于 setValue 和 postValue 在父类的权限修饰符是 protected，在这里我们改成 public，这样外部的类才能调用到
     *
     *
     *  需要注意的是 setValue 只能在主线程中调用，如果是在子线程调用要使用 postValue，否则会报错
     *
     *
     */
    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }

    @Override
    public void postValue(Integer value) {
        super.postValue(value);
    }

}
