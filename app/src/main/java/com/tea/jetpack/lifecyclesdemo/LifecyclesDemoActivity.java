package com.tea.jetpack.lifecyclesdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tea.jetpack.R;

public class LifecyclesDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles_demo);
        LifeChronometer chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }
}
