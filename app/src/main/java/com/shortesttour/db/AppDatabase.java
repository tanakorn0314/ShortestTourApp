package com.shortesttour.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {DirectionApiResult.class},version =  3)
public abstract class AppDatabase extends RoomDatabase{
    public abstract DirectionApiResultDao directionApiResultDao();

    private static volatile AppDatabase INSTANCE;

    static final Migration MIGRATION = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

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
