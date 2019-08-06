package com.amary.app.data.jetmovietvcat.data.source;

import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;

import java.util.List;

public interface JetMovieTvDataSource {

    //movies
    List<MovieEntity> getAllMovies();

    MovieEntity getDetailMovie(String movieId);

    //tvshows
    List<TvShowEntity> getAllTvShows();

    TvShowEntity getDetailTvShows(String tvId);
}
