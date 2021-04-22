package com.arztemis.BasicMusicPlayer.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class BaiHatInfo {
    @ColumnInfo(name = "MaBH")
    private int maBH;
    @ColumnInfo(name = "TenCD")
    private String tenCD;
    @ColumnInfo(name = "Ten")
    private String ten;
    @ColumnInfo(name = "Link")
    private String link;
    @ColumnInfo(name = "Casy")
    private String casy;

    public int getMaBH() {
        return maBH;
    }

    public void setMaBH(int maBH) {
        this.maBH = maBH;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
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
