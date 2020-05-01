package com.tea.jetpack.score;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tea.jetpack.R;
import com.tea.jetpack.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity implements LifecycleEventObserver {

    TeaViewModel teaViewModel;
    ActivityScoreBinding binding;
    public static String Tag = "ScoreActivity";
    private TeaLiveData mLiveData = new TeaLiveData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLifecycle().addObserver(this);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_score);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score);

        // 过时方法
        //teaViewModel = ViewModelProviders.of(this).get(TeaViewModel.class);
        // 这种方式是错误的，会导致 ViewModel 的 onCleared 方法无法正常回调
        //teaViewModel = new ViewModelProvider(getViewModelStore(),new ViewModelProvider.NewInstanceFactory()).get(TeaViewModel.class);
        // Fragment 可以共享 Activity 的 ViewModel 对象，只需要 ViewModelProvider 的构造函数中传入是的 Activity 即能共享同一个对象
        teaViewModel = new ViewModelProvider(this).get(TeaViewModel.class);

        binding.setData(teaViewModel);
        binding.setLifecycleOwner(this);


        //介绍LiveData
        /*mLiveData.observe(this, mObserver);
        mLiveData.setValue(10);
        mLiveData.removeObserver(mObserver);
        mLiveData.removeObservers(this);
        boolean hasObservers = mLiveData.hasObservers();
        boolean ha = mLiveData.hasActiveObservers();*/

        //DataBind直接在xml中赋值给TextView，此处只是介绍观察方式
        teaViewModel.getmATeamScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer point) {
                Log.d(Tag,"接收到了A的分数：" + point);
            }
        });

    }

    private Observer<Integer> mObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer point) {
            Log.d(Tag,"mLiveData：" + point);
        }
    };

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                Log.d(Tag,"当前的Lifecycle状态: Create ");
                break;
            case ON_START:
                Log.d(Tag,"当前的Lifecycle状态: Start ");
                break;
            case ON_RESUME:
                Log.d(Tag,"当前的Lifecycle状态: Resume ");
                break;
            case ON_PAUSE:
                Log.d(Tag,"当前的Lifecycle状态: Pause ");
                break;
            case ON_STOP:
                Log.d(Tag,"当前的Lifecycle状态: Stop ");
                break;
            case ON_DESTROY:
                Log.d(Tag,"当前的Lifecycle状态: Destroy ");
                break;
            default:
                break;
        }
    }

    public void getCurrentState(View view) {
        Log.d(Tag,"当前Lifecycle状态是：" + getLifecycle().getCurrentState());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(this);
    }
}
