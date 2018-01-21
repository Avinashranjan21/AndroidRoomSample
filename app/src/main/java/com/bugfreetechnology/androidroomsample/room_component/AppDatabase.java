package com.bugfreetechnology.androidroomsample.room_component;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bugfreetechnology.androidroomsample.pojo.User;

/*
*  User 1  databaseVersion -1  update 2
*  User 1  databaseVersion -2  update 3
*
*  User 2  databaseVersion -1  update      currentVersion 3
*
*
*
* */

@Database(entities = { User.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    private static final String DB_NAME = "nations.db";
    private static volatile AppDatabase instance;

    public abstract UserDao getUserDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
                context, // context
                AppDatabase.class, // Database class which extended RoomDatabase
                DB_NAME) // Database name from while .db file will be created
                /*.addMigrations(new Migration(1,4) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {

                    }
                })*/
                .allowMainThreadQueries() // this method allow us to query on main thread
                .build();
    }
}
