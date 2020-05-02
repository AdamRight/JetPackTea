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
import com.tea.jetpack.databinding.FragmentCountTitleBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountTitleFragment extends Fragment {


    public CountTitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_count_title, container, false);

        CountViewModel countViewModel = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        FragmentCountTitleBinding titleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_count_title,container,false);
        titleBinding.setTitleData(countViewModel);
        titleBinding.setLifecycleOwner(requireActivity());
        titleBinding.button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_countTitleFragment_to_countQuestionFragment);
            }
        });
        return titleBinding.getRoot();

    }



}
