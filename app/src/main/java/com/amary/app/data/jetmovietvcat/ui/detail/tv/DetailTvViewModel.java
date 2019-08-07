package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

public class DetailTvViewModel extends ViewModel {
    private String tvId;
    private JetMovieTvRepository jetMovieTvRepository;

    public DetailTvViewModel(JetMovieTvRepository jetMovieTvRepository) {
        this.jetMovieTvRepository = jetMovieTvRepository;
    }

    LiveData <TvShowEntity> getTvShow() {
        return jetMovieTvRepository.getDetailTvShows(getTvId());
    }

    private String getTvId() {
        return tvId;
    }

    void setTvId(String tvId) {
        this.tvId = tvId;
    }
}
