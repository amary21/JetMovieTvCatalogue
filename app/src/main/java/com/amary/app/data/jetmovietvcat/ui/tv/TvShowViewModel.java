package com.amary.app.data.jetmovietvcat.ui.tv;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private JetMovieTvRepository jetMovieTvRepository;

    public TvShowViewModel(JetMovieTvRepository jetMovieTvRepository) {
        this.jetMovieTvRepository = jetMovieTvRepository;
    }

    public List<TvShowEntity> getTvs(){
        return jetMovieTvRepository.getAllTvShows();
    }
}
