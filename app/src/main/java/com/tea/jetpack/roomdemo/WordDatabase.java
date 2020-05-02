package com.tea.jetpack.roomdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by jiangtea on 2020/5/3.
 */
@Database(entities = {Word.class} , version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao getWordDao();
}
