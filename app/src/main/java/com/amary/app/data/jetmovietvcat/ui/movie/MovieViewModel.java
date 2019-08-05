package com.amary.app.data.jetmovietvcat.ui.movie;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    List<MovieEntity> getMovies(){
        return DataDummy.generateDummyMovies();
    }
}
