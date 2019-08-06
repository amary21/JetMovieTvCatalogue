package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

public class DetailTvViewModel extends ViewModel {
    private TvShowEntity mTvShow;
    private String tvId;

    TvShowEntity getTvShow() {
        for (int i = 0; i < DataDummy.generateDummyTvShows().size(); i++) {
            TvShowEntity tvShowEntity = DataDummy.generateDummyTvShows().get(i);
            if (tvShowEntity.getTvId().equals(tvId)) {
                mTvShow = tvShowEntity;
            }
        }
        return mTvShow;
    }

    String getTvId() {
        return tvId;
    }

    void setTvId(String tvId) {
        this.tvId = tvId;
    }
}
