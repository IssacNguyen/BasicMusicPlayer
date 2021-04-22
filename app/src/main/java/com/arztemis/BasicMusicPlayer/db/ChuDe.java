package com.arztemis.BasicMusicPlayer.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"MaCD"})
public class ChuDe {
    @ColumnInfo(name = "MaCD")
    private int maCD;

    @NonNull
    @ColumnInfo(name = "TenCD")
    private String tenCD;

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }
}
