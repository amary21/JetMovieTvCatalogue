package com.amary.app.data.jetmovietvcat.ui.detail.tv;

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

    public TvShowEntity getTvShow() {
        return jetMovieTvRepository.getDetailTvShows(tvId);
    }

    String getTvId() {
        return tvId;
    }

    void setTvId(String tvId) {
        this.tvId = tvId;
    }
}
