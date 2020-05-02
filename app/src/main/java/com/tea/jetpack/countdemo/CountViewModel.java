package com.tea.jetpack.countdemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;

/**
 * Created by jiangtea on 2020/5/2.
 */
public class CountViewModel extends AndroidViewModel {

    private SavedStateHandle handle;
    private static String KEY_HIGH_SCORE = "key_high_score";
    private static String KEY_LEFT_NUM = "key_left_num";
    private static String KEY_RIGHT_NUM = "key_right_num";
    private static String KEY_OPERATOR = "key_operator";
    private static String KEY_ANSWER = "key_answer";
    private static String SAVE_SHP_DATA_NUM = "save_shp_data_num";
    private static String KEY_CURRENT_SCORE = "key_current_score";
    private SharedPreferences sharedPreferences;
    boolean winFlag;

    public CountViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_HIGH_SCORE)) {
            sharedPreferences = getApplication().getSharedPreferences(SAVE_SHP_DATA_NUM, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE, sharedPreferences.getInt(KEY_HIGH_SCORE, 0));
            handle.set(KEY_RIGHT_NUM, 0);
            handle.set(KEY_LEFT_NUM, 0);
            handle.set(KEY_OPERATOR, "+");
            handle.set(KEY_ANSWER, 0);
            handle.set(KEY_CURRENT_SCORE, 0);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getLeftNumber() {
        return handle.getLiveData(KEY_LEFT_NUM);
    }

    public MutableLiveData<Integer> getRightNumber() {
        return handle.getLiveData(KEY_RIGHT_NUM);
    }

    public MutableLiveData<Integer> getHighScore() {
        return handle.getLiveData(KEY_HIGH_SCORE);
    }

    public MutableLiveData<Integer> getCurrentScore() {
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }

    public MutableLiveData<Integer> getAnswer() {
        return handle.getLiveData(KEY_ANSWER);
    }

    public MutableLiveData<String> getOperator() {
        return handle.getLiveData(KEY_OPERATOR);
    }

    void generator() {
        int level = 20;
        Random random = new Random();
        int x, y;
        x = random.nextInt(level) + 1;
        y = random.nextInt(level) + 1;
        int value = x > y ? (x - y) : (y - x);
        if (x % 2 == 0) {

            getOperator().setValue("+");
            getAnswer().setValue(x > y ? x : y);
            getLeftNumber().setValue(x > y ? y : x);
            getRightNumber().setValue(value);
        } else {
            getOperator().setValue("-");
            getAnswer().setValue(value);
            getLeftNumber().setValue(x > y ? x : y);
            getRightNumber().setValue(x > y ? y : x);
        }
    }

    void save() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(KEY_HIGH_SCORE, getHighScore().getValue());
        edit.apply();
    }

    void answerCorrect() {
        getCurrentScore().setValue(getCurrentScore().getValue() + 1);
        if (getCurrentScore().getValue() > getHighScore().getValue()) {
            getHighScore().setValue(getCurrentScore().getValue());
            winFlag = true;
        }
        generator();
    }


}
