package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

public class DetailMovieViewModel extends ViewModel {
    private MovieEntity mMovie;
    private String movieId;

    MovieEntity getMovies(){
        for (int i=0;i< DataDummy.generateDummyMovies().size();i++){
            MovieEntity movieEntity = DataDummy.generateDummyMovies().get(i);
            if (movieEntity.getMovieId().equals(movieId)){
                mMovie = movieEntity;
            }
        }
        return mMovie;
    }

    String getMovieId() {
        return movieId;
    }

    void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
