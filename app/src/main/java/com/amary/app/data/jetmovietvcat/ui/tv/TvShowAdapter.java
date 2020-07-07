package com.amary.app.data.jetmovietvcat.ui.tv;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.ui.detail.tv.DetailTvActivity;
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    private final Activity activity;
    private List<TvShowEntity> tvShow = new ArrayList<>();

    TvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShowEntity> getListTvShow() {
        return tvShow;
    }

    void setListTvShow(List<TvShowEntity> tvShow) {
        if (tvShow == null)return;
        this.tvShow.clear();
        this.tvShow.addAll(tvShow);
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvs, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.tvTitle.setText(getListTvShow().get(position).getTvTitle());
        holder.tvDate.setText(getListTvShow().get(position).getTvDate());
        holder.tvRate.setText(getListTvShow().get(position).getTvRate());
        GlideApp.with(holder.itemView.getContext())
                .load(getListTvShow().get(position).getImgTvPoster())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgPoster);
        GlideApp.with(holder.itemView.getContext())
                .load(getListTvShow().get(position).getImgTvBg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgBg);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailTvActivity.class);
            intent.putExtra(DetailTvActivity.EXTRA_TV, getListTvShow().get(position).getTvId());
            intent.putExtra(DetailTvActivity.TITLE_TV, getListTvShow().get(position).getTvTitle());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_tv_title)
        TextView tvTitle;
        @BindView(R.id.txt_tv_date)
        TextView tvDate;
        @BindView(R.id.txt_tv_rate)
        TextView tvRate;
        @BindView(R.id.img_tv_poster)
        ImageView imgPoster;
        @BindView(R.id.img_tv_bg)
        ImageView imgBg;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
