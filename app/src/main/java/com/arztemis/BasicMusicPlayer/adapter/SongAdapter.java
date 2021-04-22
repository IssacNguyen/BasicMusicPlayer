package com.arztemis.BasicMusicPlayer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arztemis.BasicMusicPlayer.AnimAdapter;
import com.arztemis.BasicMusicPlayer.OnActionCallBack;
import com.arztemis.BasicMusicPlayer.R;
import com.arztemis.BasicMusicPlayer.db.BaiHatInfo;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {
    private List<BaiHatInfo> listBH;
    private Context context;
    private BaiHatInfo dataSelected;
    private OnActionCallBack callBack;

    public SongAdapter(List<BaiHatInfo> listBH,
                       Context context, OnActionCallBack event) {
        this.listBH = listBH;
        this.context = context;
        callBack = event;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, int position) {
        BaiHatInfo item = listBH.get(position);
        holder.tvSong.setText(item.getTen());
        holder.tvSinger.setText(item.getCasy());

        holder.tvSong.setTag(item);
        holder.lnSong.setBackgroundColor(Color.WHITE);

        if (dataSelected != null && dataSelected == item) {
            holder.lnSong.setBackgroundColor(Color.parseColor("#eeeeee"));
        }
    }

    @Override
    public int getItemCount() {
        return listBH.size();
    }

    public void initFirst() {
        dataSelected = listBH.get(0);
        notifyDataSetChanged();
        callBack.callBack(dataSelected);
    }

    public class SongHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvSong, tvSinger;
        LinearLayout lnSong;

        public SongHolder(@NonNull View itemView) {
            super(itemView);

            lnSong = itemView.findViewById(R.id.ln_song);
            tvSong = itemView.findViewById(R.id.tv_song);
            tvSinger = itemView.findViewById(R.id.tv_singer);

            tvSinger.setOnClickListener(this);
            tvSong.setOnClickListener(this);
            lnSong.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Animation anim = AnimationUtils.loadAnimation(context, R.anim.anim_alpha);
            anim.setAnimationListener(new AnimAdapter() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    dataSelected = (BaiHatInfo) tvSong.getTag();
                    notifyDataSetChanged();
                    callBack.callBack(dataSelected);
                }
            });
            lnSong.startAnimation(anim);
        }
    }
}
