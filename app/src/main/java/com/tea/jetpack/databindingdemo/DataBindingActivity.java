package com.tea.jetpack.databindingdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.tea.jetpack.R;
import com.tea.jetpack.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    private ActivityDataBindingBinding viewDataBinding;
    private ViewModelWithData viewModelWithData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_binding);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        viewModelWithData = new ViewModelProvider(this).get(ViewModelWithData.class);
        viewDataBinding.setData(viewModelWithData);
        viewDataBinding.setLifecycleOwner(this);
    }
}
