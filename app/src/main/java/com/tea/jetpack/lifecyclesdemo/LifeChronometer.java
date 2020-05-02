package com.tea.jetpack.lifecyclesdemo;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by jiangtea on 2020/5/3.
 */
public class LifeChronometer extends Chronometer implements LifecycleObserver {
    private long elapsedTime;
    public LifeChronometer(Context context) {
        this(context, null);
    }

    public LifeChronometer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public LifeChronometer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter(){
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }

}
