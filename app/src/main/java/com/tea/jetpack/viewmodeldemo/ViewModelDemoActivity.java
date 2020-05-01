package com.tea.jetpack.viewmodeldemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.tea.jetpack.R;

public class ViewModelDemoActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Button button2;
    private ViewModelTest viewModelTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_demo);
        viewModelTest = new ViewModelProvider(this).get(ViewModelTest.class);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        textView.setText(String.valueOf(viewModelTest.num));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelTest.num ++ ;
                textView.setText(String.valueOf(viewModelTest.num));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelTest.num += 2;
                textView.setText(String.valueOf(viewModelTest.num));
            }
        });
    }
}
