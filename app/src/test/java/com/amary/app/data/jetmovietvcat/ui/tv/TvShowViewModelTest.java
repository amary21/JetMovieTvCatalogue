package com.amary.app.data.jetmovietvcat.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =new InstantTaskExecutorRule();

    private TvShowViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel(jetMovieTvRepository);
    }

    @Test
    public void getTvs() {
        MutableLiveData<List<TvShowEntity>> tvShowEntities = new MutableLiveData<>();
        tvShowEntities.setValue(FakeDataDummy.generateDummyTvShows());
        when(jetMovieTvRepository.getAllTvShows()).thenReturn(tvShowEntities);
        Observer<List<TvShowEntity>> observer = Mockito.mock(Observer.class);
        viewModel.getTvs().observeForever(observer);
        verify(jetMovieTvRepository).getAllTvShows();
    }
}