package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailTvViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =new InstantTaskExecutorRule();

    private DetailTvViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);
    private TvShowEntity tvShowsDummy = FakeDataDummy.generateDummyTvShows().get(0);
    private String tvShowId = tvShowsDummy.getTvId();

    @Before
    public void setUp(){
        viewModel = new DetailTvViewModel(jetMovieTvRepository);
        viewModel.setTvId(tvShowId);
    }

    @Test
    public void getTvShow() {
        MutableLiveData<TvShowEntity> tvShowEntity = new MutableLiveData<>();
        tvShowEntity.setValue(tvShowsDummy);

        when(jetMovieTvRepository.getDetailTvShows(tvShowId)).thenReturn(tvShowEntity);

        Observer<TvShowEntity> observer = mock(Observer.class);
        viewModel.getTvShow().observeForever(observer);

        verify(jetMovieTvRepository).getDetailTvShows(tvShowId);
    }
}