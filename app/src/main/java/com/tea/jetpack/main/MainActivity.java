package com.tea.jetpack.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tea.jetpack.R;
import com.tea.jetpack.score.ScoreActivity;

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
        mDatas.add(new MainListBean("计分", ScoreActivity.class));
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this, mDatas.get(position).getActvity()));
    }
}
