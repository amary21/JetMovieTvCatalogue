package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

public class DetailMovieViewModel extends ViewModel {
    private String movieId;
    private JetMovieTvRepository jetMovieTvRepository;

    public DetailMovieViewModel(JetMovieTvRepository jetMovieTvRepository) {
        this.jetMovieTvRepository = jetMovieTvRepository;
    }

    public MovieEntity getMovies(){
        return jetMovieTvRepository.getDetailMovie(movieId);
    }

    String getMovieId() {
        return movieId;
    }

    void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
