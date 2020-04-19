package com.tea.jetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by jiangtea on 2020/4/19.
 */
public class TeaViewModel extends ViewModel {
    private MutableLiveData<Integer> mATeamScore;
    private MutableLiveData<Integer> mBTeamScore;

    private int aBack, bBack;

    public MutableLiveData<Integer> getmATeamScore() {
        if (mATeamScore == null) {
            mATeamScore = new MutableLiveData<>();
            mATeamScore.setValue(0);
        }
        return mATeamScore;
    }

    public MutableLiveData<Integer> getmBTeamScore() {
        if (mBTeamScore == null) {
            mBTeamScore = new MutableLiveData<>();
            mBTeamScore.setValue(0);
        }
        return mBTeamScore;
    }

    public void aTeamAdd(int point) {
        saveScore();
        mATeamScore.setValue(mATeamScore.getValue() + point);
    }

    public void bTeamAdd(int point) {
        saveScore();
        mBTeamScore.setValue(mBTeamScore.getValue() + point);
    }

    public void reset() {
        saveScore();
        mATeamScore.setValue(0);
        mBTeamScore.setValue(0);
    }

    public void undo(){
        mATeamScore.setValue(aBack);
        mBTeamScore.setValue(bBack);
    }

    private void saveScore() {
        aBack = mATeamScore.getValue();
        bBack = mBTeamScore.getValue();
    }


}
