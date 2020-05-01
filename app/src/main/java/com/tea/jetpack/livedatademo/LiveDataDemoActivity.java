package com.tea.jetpack.livedatademo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tea.jetpack.R;

public class LiveDataDemoActivity extends AppCompatActivity {

    private LiveModelWithData liveModelWithData;
    private TextView textView2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_demo);

        textView2 = findViewById(R.id.textView2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        liveModelWithData = new ViewModelProvider(this).get(LiveModelWithData.class);
        liveModelWithData.getNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView2.setText(String.valueOf(integer));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveModelWithData.changeNum(1);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveModelWithData.changeNum(-1);
            }
        });

    }
}
