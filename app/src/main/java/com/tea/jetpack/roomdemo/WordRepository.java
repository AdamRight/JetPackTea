package com.tea.jetpack.roomdemo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by jiangtea on 2020/5/17.
 */
public class WordRepository {

    private final WordDatabase mWordDatabase;
    private final WordDao mWordDao;
    private final LiveData<List<Word>> allWords;

    public WordRepository(Context context) {
        mWordDatabase = WordDatabase.getInstance(context);
        mWordDao = mWordDatabase.getWordDao();
        allWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word... words) {
        new InsertAsyncTask(mWordDao).execute(words);
    }

    public void updata(Word... words) {
        new UpdataAsyncTask(mWordDao).execute(words);
    }

    public void delete(Word... words) {
        new DeleteAsyncTask(mWordDao).execute(words);
    }

    public void clear() {
        new ClearAsyncTask(mWordDao).execute();
    }

    public static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }
    }

    static class UpdataAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public UpdataAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao wordDao;

        public ClearAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }
}
