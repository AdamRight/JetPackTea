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
import com.tea.jetpack.databinding.FragmentCountLoseBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountLoseFragment extends Fragment {


    public CountLoseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_count_lose, container, false);
        CountViewModel countViewModel = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        FragmentCountLoseBinding loseBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_count_lose,container,false);
        loseBinding.setLoseData(countViewModel);
        loseBinding.setLifecycleOwner(requireActivity());
        loseBinding.button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_countLoseFragment_to_countTitleFragment);
            }
        });
        return loseBinding.getRoot();
    }

}
