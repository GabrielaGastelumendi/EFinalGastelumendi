package com.gabriela.efinal.db;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.gabriela.efinal.model.ShowEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShowEntity.class}, version = 1)
public abstract class DogDatabase extends RoomDatabase {
    public abstract DogDao dogDao();
    private static volatile DogDatabase db;

    public static final ExecutorService dataBaseWriteExecutor =
            Executors.newFixedThreadPool(4);

    public static DogDatabase getInstance(Context context){
        if(db == null){
            synchronized (DogDatabase.class){
                if (db == null){
                    db = Room.databaseBuilder(context.getApplicationContext(),
                            DogDatabase.class, "shows-database").build();
                }
            }
        }
        return db;
    }
}
