package com.tea.jetpack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.tea.jetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    TeaViewModel teaViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        teaViewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory())
                .get(TeaViewModel.class);
        binding.setData(teaViewModel);
        binding.setLifecycleOwner(this);

    }
}
