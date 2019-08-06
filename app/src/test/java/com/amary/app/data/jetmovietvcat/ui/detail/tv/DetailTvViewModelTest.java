package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailTvViewModelTest {
    private DetailTvViewModel viewModel;
    private TvShowEntity tvShowEntity;

    @Before
    public void setUp(){
        viewModel = new DetailTvViewModel();
        tvShowEntity = new TvShowEntity("t06",
                "Family Guy",
                "January 31, 1999",
                "6.5",
                "https://image.tmdb.org/t/p/w342/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "https://image.tmdb.org/t/p/w342/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.");
    }

    @After
    public void teatDown(){

    }

    @Test
    public void getTvShow() {
        viewModel.setTvId(tvShowEntity.getTvId());
        TvShowEntity entity = viewModel.getTvShow();
        assertNotNull(entity);
        assertEquals(tvShowEntity.getTvId(), entity.getTvId());
        assertEquals(tvShowEntity.getTvTitle(), entity.getTvTitle());
        assertEquals(tvShowEntity.getTvDate(), entity.getTvDate());
        assertEquals(tvShowEntity.getTvRate(), entity.getTvRate());
        assertEquals(tvShowEntity.getImgTvPoster(), entity.getImgTvPoster());
        assertEquals(tvShowEntity.getImgTvBg(), entity.getImgTvBg());
        assertEquals(tvShowEntity.getTvSynopsis(), entity.getTvSynopsis());
    }
}