package com.amary.app.data.jetmovietvcat.ui.tv;

import com.amary.app.data.jetmovietvcat.data.local.TvShowEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void getTvs() {
        List<TvShowEntity> tvShowEntities = viewModel.getTvs();
        assertNotNull(tvShowEntities);
        assertEquals(10, tvShowEntities.size());
    }
}