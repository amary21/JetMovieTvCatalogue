package com.amary.app.data.jetmovietvcat.ui.tv;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {
    private TvShowViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel(jetMovieTvRepository);
    }

    @Test
    public void getTvs() {
        when(jetMovieTvRepository.getAllTvShows()).thenReturn(FakeDataDummy.generateDummyTvShows());
        List<TvShowEntity> tvShowEntities = viewModel.getTvs();
        verify(jetMovieTvRepository).getAllTvShows();
        assertNotNull(tvShowEntities);
        assertEquals(10, tvShowEntities.size());
    }
}