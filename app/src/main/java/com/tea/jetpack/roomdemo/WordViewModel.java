package com.tea.jetpack.roomdemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by jiangtea on 2020/5/17.
 */
public class WordViewModel extends AndroidViewModel {

    private final WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);

    }

    public LiveData<List<Word>> getAllWords() {
        return wordRepository.getAllWords();
    }

    public void insert(Word... words) {
        wordRepository.insert(words);
    }

    public void updata(Word... words) {
        wordRepository.updata(words);
    }

    public void delete(Word... words) {
        wordRepository.delete(words);
    }

    public void clear() {
        wordRepository.clear();
    }

}
