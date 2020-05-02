package com.tea.jetpack.countdemo;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.tea.jetpack.R;

public class CountNumActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_num);
        navController = Navigation.findNavController(this, R.id.fragment3);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (navController.getCurrentDestination().getId() == R.id.countQuestionFragment) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("确定退出吗");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    navController.navigateUp();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create().show();
        } else if (navController.getCurrentDestination().getId() == R.id.countTitleFragment) {
            finish();
        } else {
            navController.navigate(R.id.countTitleFragment);
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        onSupportNavigateUp();
    }
}
