package com.tea.jetpack.roomdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by jiangtea on 2020/5/3.
 */
@Database(entities = {Word.class} , version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase instance;
    public synchronized static WordDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_database2")
                    .build();
        }
        return instance;
    }
    public abstract WordDao getWordDao();
}
