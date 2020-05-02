package com.tea.jetpack.countdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tea.jetpack.R;
import com.tea.jetpack.databinding.FragmentCountQuestionBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountQuestionFragment extends Fragment {


    public CountQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_count_question, container, false);
        final CountViewModel countViewModel = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        countViewModel.generator();
        countViewModel.getCurrentScore().setValue(0);
        final FragmentCountQuestionBinding questionBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_count_question, container, false);
        questionBinding.setQuesData(countViewModel);
        questionBinding.setLifecycleOwner(requireActivity());

        final StringBuilder stringBuilder = new StringBuilder();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_num_0:
                        stringBuilder.append(0);
                        break;
                    case R.id.button_num_1:
                        stringBuilder.append(1);
                        break;
                    case R.id.button_num_2:
                        stringBuilder.append(2);
                        break;
                    case R.id.button_num_3:
                        stringBuilder.append(3);
                        break;
                    case R.id.button_num_4:
                        stringBuilder.append(4);
                        break;
                    case R.id.button_num_5:
                        stringBuilder.append(5);
                        break;
                    case R.id.button_num_6:
                        stringBuilder.append(6);
                        break;
                    case R.id.button_num_7:
                        stringBuilder.append(7);
                        break;
                    case R.id.button_num_8:
                        stringBuilder.append(8);
                        break;
                    case R.id.button_num_9:
                        stringBuilder.append(9);
                        break;
                    case R.id.button_num_clear:
                        stringBuilder.setLength(0);
                        break;
                }
                questionBinding.answerTv.setText(stringBuilder.length() == 0 ? getString(R.string.continue_answer) : stringBuilder.toString());
            }
        };
        questionBinding.buttonNum0.setOnClickListener(onClickListener);
        questionBinding.buttonNum1.setOnClickListener(onClickListener);
        questionBinding.buttonNum2.setOnClickListener(onClickListener);
        questionBinding.buttonNum3.setOnClickListener(onClickListener);
        questionBinding.buttonNum4.setOnClickListener(onClickListener);
        questionBinding.buttonNum5.setOnClickListener(onClickListener);
        questionBinding.buttonNum6.setOnClickListener(onClickListener);
        questionBinding.buttonNum7.setOnClickListener(onClickListener);
        questionBinding.buttonNum8.setOnClickListener(onClickListener);
        questionBinding.buttonNum9.setOnClickListener(onClickListener);
        questionBinding.buttonNumClear.setOnClickListener(onClickListener);
        questionBinding.buttonNumConfirm.setOnClickListener(onClickListener);

        questionBinding.buttonNumConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stringBuilder.length() == 0){
                    return;
                }
                if (Integer.valueOf(stringBuilder.toString()) == countViewModel.getAnswer().getValue()) {
                    countViewModel.answerCorrect();
                    stringBuilder.setLength(0);
                    questionBinding.answerTv.setText(getString(R.string.continue_answer));
                } else {
                    NavController navController = Navigation.findNavController(view);
                    if (countViewModel.winFlag){
                        navController.navigate(R.id.action_countQuestionFragment_to_countWinFragment);
                        countViewModel.winFlag = false;
                        countViewModel.save();
                    } else {
                        navController.navigate(R.id.action_countQuestionFragment_to_countLoseFragment);
                    }
                }
            }
        });

        return questionBinding.getRoot();
    }

}
