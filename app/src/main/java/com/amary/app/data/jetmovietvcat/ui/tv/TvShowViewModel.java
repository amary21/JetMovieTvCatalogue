package com.amary.app.data.jetmovietvcat.ui.tv;

import androidx.lifecycle.ViewModel;

import com.amary.app.data.jetmovietvcat.data.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    List<TvShowEntity> getTvs(){
        return DataDummy.generateDummyTvShows();
    }
}
