package com.tea.jetpack.navigationdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.tea.jetpack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //接收数据
        String fragment_key = getArguments().getString("fragment_key");
        Toast.makeText(getActivity(),fragment_key,Toast.LENGTH_SHORT).show();

        getView().findViewById(R.id.button13).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_homeFragment)
        );
    }

}
