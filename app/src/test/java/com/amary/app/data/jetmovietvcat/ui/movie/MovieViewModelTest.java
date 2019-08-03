package com.amary.app.data.jetmovietvcat.ui.movie;

import com.amary.app.data.jetmovietvcat.data.MovieEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities =viewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}