package com.arztemis.BasicMusicPlayer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arztemis.BasicMusicPlayer.adapter.SongAdapter;
import com.arztemis.BasicMusicPlayer.db.BaiHatInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnActionCallBack, View.OnClickListener {

    private static final String TAG = MainActivity.class.getName();
    private RecyclerView rvSong;
    private ImageView ivPlay, ivBack, ivNext;
    private TextView tvSong, tvSinger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivNext = findViewById(R.id.iv_next);
        ivPlay = findViewById(R.id.iv_play);

        tvSinger = findViewById(R.id.tv_singer);
        tvSong = findViewById(R.id.tv_song);

        ivPlay.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        ivBack.setOnClickListener(this);

        rvSong = findViewById(R.id.rv_song);
        rvSong.setLayoutManager(new LinearLayoutManager(this));

        BaiHatManager.getInstance().getAllBH(new OnActionCallBack() {
            @Override
            public void callBack(Object data) {
                //MainThread
                List<BaiHatInfo> listBH = (List<BaiHatInfo>) data;
                Log.i(TAG, "listBH: " + listBH.size());
                SongAdapter adapter = new SongAdapter(listBH, MainActivity.this, MainActivity.this);
                rvSong.setAdapter(adapter);
                adapter.initFirst();
            }
        });
    }

    @Override
    public void callBack(Object data) {
        BaiHatInfo baiHat = (BaiHatInfo) data;
        tvSong.setText(baiHat.getTen());
        tvSinger.setText(baiHat.getCasy());
    }

    @Override
    public void onClick(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_alpha));
        if (view.getId() == R.id.iv_play) {
            ivPlay.setImageLevel(ivPlay.getDrawable().getLevel() == 0 ? 1 : 0);
        }
    }
}