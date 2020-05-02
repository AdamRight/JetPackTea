package com.tea.jetpack.navogationdemo2;


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
import com.tea.jetpack.databinding.FragmentAddNumBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNumFragment extends Fragment {


    public AddNumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add_num, container, false);
        ViewModelWithNavigation viewModelWithNavigation = new ViewModelProvider(requireActivity()).get(ViewModelWithNavigation.class);
        FragmentAddNumBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_num, container, false);
        binding.setMydata(viewModelWithNavigation);
        binding.setLifecycleOwner(requireActivity());

        binding.button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_addNumFragment_to_deleteNumFragment);
            }
        });

        return binding.getRoot();
    }

}
