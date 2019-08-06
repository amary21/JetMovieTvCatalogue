package com.amary.app.data.jetmovietvcat.ui.movie;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private JetMovieTvRepository jetMovieTvRepository;

    public MovieViewModel(JetMovieTvRepository jetMovieTvRepository) {
        this.jetMovieTvRepository = jetMovieTvRepository;
    }

    public List<MovieEntity> getMovies(){
        return jetMovieTvRepository.getAllMovies();
    }
}
