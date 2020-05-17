package com.tea.jetpack.roomdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tea.jetpack.R;

import java.util.List;

public class RoomDemo1Activity extends AppCompatActivity {

    private Button buttonInsert, buttonUpdata, buttonClear, buttonDelete;
    private WordViewModel mWordViewModel;
    private RecyclerView recyclerView;
    private RoomDemoAdapter roomDemoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_demo1);

        buttonInsert = findViewById(R.id.button21);
        buttonUpdata = findViewById(R.id.button22);
        buttonClear = findViewById(R.id.button23);
        buttonDelete = findViewById(R.id.button24);

        recyclerView = findViewById(R.id.recycler_view);
        roomDemoAdapter = new RoomDemoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(roomDemoAdapter);

        /*mWordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word_database")
                .allowMainThreadQueries()//开发中不会这样设置
                .build();
        mWordDao = mWordDatabase.getWordDao();
        allWords = mWordDao.getAllWords();*/
        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                /*StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append(",").append(word.getMeaning()).append("\n");
                }
                tvShow.setText(text.toString());*/
                roomDemoAdapter.setWords(words);
                roomDemoAdapter.notifyDataSetChanged();
            }
        });

        //updateView();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("hello", "你好");
                Word word2 = new Word("hello", "你好");
                //mWordDao.insertWords(word,word2);
                //updateView();
                mWordViewModel.insert(word, word2);
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mWordDao.deleteAllWords();
                //updateView();
                mWordViewModel.clear();
            }
        });
        buttonUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("hi", "你好啊");
                word.setId(66);
                //mWordDao.updateWords(word);
                //updateView();
                mWordViewModel.updata(word);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("hi", "你好啊");
                word.setId(67);
                //mWordDao.deleteWords(word);
                //updateView();
                mWordViewModel.delete(word);
            }
        });

    }

    /*private void updateView() {
        List<Word> allWords = mWordDao.getAllWords();
        String text = "";
        for (int i = 0; i < allWords.size(); i++) {
            Word word = allWords.get(i);
            text += word.getId() + ":" + word.getWord() + "," + word.getMeaning() + "\n";
        }
        tvShow.setText(text);
    }*/

}
