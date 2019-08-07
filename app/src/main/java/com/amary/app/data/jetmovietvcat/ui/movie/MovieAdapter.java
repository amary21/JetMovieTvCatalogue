package com.amary.app.data.jetmovietvcat.ui.movie;

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
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.ui.detail.movie.DetailMovieActivity;
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final Activity activity;
    private List<MovieEntity> mMovie = new ArrayList<>();

    MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieEntity> getListMovie() {
        return mMovie;
    }

    void setListMovie(List<MovieEntity> mMovie) {
        if (mMovie == null) return;
        this.mMovie.clear();
        this.mMovie.addAll(mMovie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getListMovie().get(position).getMovieTitle());
        holder.tvDate.setText(getListMovie().get(position).getMovieDate());
        holder.tvRate.setText(getListMovie().get(position).getMovieRate());
        GlideApp.with(holder.itemView.getContext())
                .load(getListMovie().get(position).getImgMoviePoster())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgPoster);
        GlideApp.with(holder.itemView.getContext())
                .load(getListMovie().get(position).getImgMovieBg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgBg);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getListMovie().get(position).getMovieId());
            intent.putExtra(DetailMovieActivity.TITLE_MOVIE, getListMovie().get(position).getMovieTitle());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDate;
        final TextView tvRate;
        final ImageView imgPoster;
        final ImageView imgBg;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txt_movie_title);
            tvDate = itemView.findViewById(R.id.txt_movie_date);
            tvRate = itemView.findViewById(R.id.txt_movie_rate);
            imgPoster = itemView.findViewById(R.id.img_movie_poster);
            imgBg = itemView.findViewById(R.id.img_movie_bg);
        }
    }
}
