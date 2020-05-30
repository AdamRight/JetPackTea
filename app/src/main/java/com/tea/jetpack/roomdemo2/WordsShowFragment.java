package com.tea.jetpack.roomdemo2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tea.jetpack.R;
import com.tea.jetpack.roomdemo2.word.MyAdapter;
import com.tea.jetpack.roomdemo2.word.Word;
import com.tea.jetpack.roomdemo2.word.WordViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordsShowFragment extends Fragment {


    private WordViewModel wordViewModel;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter1;
    private MyAdapter myAdapter2;

    public WordsShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        recyclerView = requireActivity().findViewById(R.id.recycler_view_room_word);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        myAdapter1 = new MyAdapter(false, wordViewModel);
        myAdapter2 = new MyAdapter(true, wordViewModel);
        recyclerView.setAdapter(myAdapter1);
        wordViewModel.getAllWordsLive().observe(requireActivity(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                int temp = myAdapter1.getItemCount();
                myAdapter1.setAllWords(words);
                myAdapter2.setAllWords(words);
                if (temp!=words.size()) {
                    myAdapter1.notifyDataSetChanged();
                    myAdapter2.notifyDataSetChanged();
                }
            }
        });
        /*String[] english = {
                "Hello",
                "World",
                "Android",
                "Google",
                "Studio",
                "Project",
                "Database",
                "Recycler",
                "View",
                "String",
                "Value",
                "Integer"
        };
        String[] chinese = {
                "你好",
                "世界",
                "安卓系统",
                "谷歌公司",
                "工作室",
                "项目",
                "数据库",
                "回收站",
                "视图",
                "字符串",
                "价值",
                "整数类型"
        };
        for(int i = 0;i<english.length;i++) {
            wordViewModel.insertWords(new Word(english[i],chinese[i]));
        }*/
        FloatingActionButton floatingActionButton = requireActivity().findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_wordsShowFragment_to_wordsAddFragment);
            }
        });
    }
}
