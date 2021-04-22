package com.arztemis.BasicMusicPlayer;

import android.app.Application;

import androidx.room.Room;

import com.arztemis.BasicMusicPlayer.db.AppDB;

public class App extends Application {
    private static App instance;
    private AppDB mDB;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDB();
    }

    private void initDB() {
        mDB = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "BaiHat")
                .createFromAsset("BaiHat.db")
                .build();
    }

    public AppDB getDB() {
        return mDB;
    }
}
