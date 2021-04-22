package com.arztemis.BasicMusicPlayer.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"MaBH"})
public class BaiHat {
    @ColumnInfo(name = "MaCD")
    @NonNull
    private int maCD;
    @ColumnInfo(name = "MaBH")
    private int maBH;

    @NonNull
    @ColumnInfo(name = "Ten")
    private String ten;

    @NonNull
    @ColumnInfo(name = "Link")
    private String link;

    @NonNull
    @ColumnInfo(name = "Casy")
    private String casy;

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public int getMaBH() {
        return maBH;
    }

    public void setMaBH(int maBH) {
        this.maBH = maBH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCasy() {
        return casy;
    }

    public void setCasy(String casy) {
        this.casy = casy;
    }
}
