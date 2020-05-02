package com.tea.jetpack.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tea.jetpack.R;
import com.tea.jetpack.countdemo.CountNumActivity;
import com.tea.jetpack.databindingdemo.DataBindingActivity;
import com.tea.jetpack.lifecyclesdemo.LifecyclesDemoActivity;
import com.tea.jetpack.livedatademo.LiveDataDemoActivity;
import com.tea.jetpack.navigationdemo.NavigationTeaActivity;
import com.tea.jetpack.navogationdemo2.NumFragmentActivity;
import com.tea.jetpack.scoredemo.ScoreActivity;
import com.tea.jetpack.viewmodeldemo.ViewModelDemoActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    private ArrayList<MainListBean> mDatas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateDatas();

        initView();
    }

    @SuppressLint("WrongConstant")
    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        MainAdapter adapter = new MainAdapter(this, mDatas);
        adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void generateDatas() {
        mDatas.add(new MainListBean("ViewModel-demo", ViewModelDemoActivity.class));
        mDatas.add(new MainListBean("LiveData-demo", LiveDataDemoActivity.class));
        mDatas.add(new MainListBean("DataBinding-demo以及SavedStateHandle", DataBindingActivity.class));
        mDatas.add(new MainListBean("计分器demo", ScoreActivity.class));
        mDatas.add(new MainListBean("Navigation-fragment切换和数据传递", NavigationTeaActivity.class));
        mDatas.add(new MainListBean("Navigation-viewmodel", NumFragmentActivity.class));
        mDatas.add(new MainListBean("口算demo", CountNumActivity.class));
        mDatas.add(new MainListBean("Lifecycles-demo", LifecyclesDemoActivity.class));
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this, mDatas.get(position).getActvity()));
    }
}
