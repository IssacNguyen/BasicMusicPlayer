package com.arztemis.BasicMusicPlayer.db;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BaiHatDAO {
    @Query("SELECT MaBH, TenCD, Ten, Link, Casy " +
            "FROM BaiHat INNER JOIN ChuDe ON BaiHat.MaCD = ChuDe.MaCD")
    List<BaiHatInfo> getListBH();

    @Query("SELECT MaBH, TenCD, Ten, Link, Casy " +
            "FROM BaiHat INNER JOIN ChuDe ON BaiHat.MaCD = ChuDe.MaCD " +
            "WHERE TenCD = :tenCD")
    List<BaiHatInfo> findListBHByCD(String tenCD);
}
