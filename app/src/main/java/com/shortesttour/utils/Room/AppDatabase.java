package com.shortesttour.utils.Room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {PlaceEntity.class,DirectionApiResult.class},version =  1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract PlaceDao placeDao();
    public abstract DirectionApiResultDao directionApiResultDao();

    private static volatile AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context contxt){
        if(INSTANCE==null){
            synchronized (AppDatabase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(contxt.getApplicationContext(),AppDatabase.class,"app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}