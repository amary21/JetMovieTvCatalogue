package com.amary.app.data.jetmovietvcat.data.source;

import androidx.lifecycle.LiveData;

import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;

import java.util.List;

public interface JetMovieTvDataSource {

    LiveData<List<MovieEntity>> getAllMovies();

    LiveData<MovieEntity> getDetailMovie(String movieId);

    LiveData<List<TvShowEntity>> getAllTvShows();

    LiveData<TvShowEntity> getDetailTvShows(String tvId);
}
