package com.arztemis.BasicMusicPlayer.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BaiHat.class, ChuDe.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract BaiHatDAO getBaiHatDAO();
}
