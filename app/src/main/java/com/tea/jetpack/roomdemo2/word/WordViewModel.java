package com.tea.jetpack.roomdemo2.word;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }

    public void insertWords(Word... words) {
        wordRepository.insertWords(words);
    }
    void updateWords(Word... words) {
        wordRepository.updateWords(words);
    }
    public void deleteWords(Word... words) {
        wordRepository.deleteWords(words);
    }
    public void deleteAllWords() {
        wordRepository.deleteAllWords();
    }

    public LiveData<List<Word>> findWordsWithPattern(String patten) {
        return wordRepository.findWordsWithPattern(patten);
    }
}
