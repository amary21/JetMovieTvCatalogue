package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailTvViewModelTest {
    private DetailTvViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);
    private TvShowEntity tvShowEntity = FakeDataDummy.generateDummyTvShows().get(0);
    private String tvShowId = tvShowEntity.getTvId();

    @Before
    public void setUp(){
        viewModel = new DetailTvViewModel(jetMovieTvRepository);
        viewModel.setTvId(tvShowId);
    }

    @Test
    public void getTvShow() {
        when(jetMovieTvRepository.getDetailTvShows(tvShowId)).thenReturn(tvShowEntity);
        TvShowEntity entity = viewModel.getTvShow();
        verify(jetMovieTvRepository).getDetailTvShows(tvShowId);
        assertNotNull(entity);

        assertNotNull(entity.getTvId());
        assertNotNull(entity.getTvTitle());
        assertNotNull(entity.getTvDate());
        assertNotNull(entity.getTvRate());
        assertNotNull(entity.getImgTvPoster());
        assertNotNull(entity.getImgTvBg());
        assertNotNull(entity.getTvSynopsis());

        assertEquals(tvShowEntity.getTvId(), entity.getTvId());
        assertEquals(tvShowEntity.getTvTitle(), entity.getTvTitle());
        assertEquals(tvShowEntity.getTvDate(), entity.getTvDate());
        assertEquals(tvShowEntity.getTvRate(), entity.getTvRate());
        assertEquals(tvShowEntity.getImgTvPoster(), entity.getImgTvPoster());
        assertEquals(tvShowEntity.getImgTvBg(), entity.getImgTvBg());
        assertEquals(tvShowEntity.getTvSynopsis(), entity.getTvSynopsis());
    }
}