package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import com.amary.app.data.jetmovietvcat.data.MovieEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModel;
    private MovieEntity movieEntity;

    @Before
    public void setUp(){
        viewModel = new DetailMovieViewModel();
        movieEntity = new MovieEntity("m08",
                "Glass",
                "January 16, 2019",
                "6.5",
                "https://image.tmdb.org/t/p/w342/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "https://image.tmdb.org/t/p/w342/ngBFDOsx13sFXiMweDoL54XYknR.jpg",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void getMovies() {
        viewModel.setMovieId(movieEntity.getMovieId());
        MovieEntity entity = viewModel.getMovies();
        assertNotNull(entity);
        assertEquals(movieEntity.getMovieId(), entity.getMovieId());
        assertEquals(movieEntity.getMovieTitle(), entity.getMovieTitle());
        assertEquals(movieEntity.getMovieDate(), entity.getMovieDate());
        assertEquals(movieEntity.getMovieRate(), entity.getMovieRate());
        assertEquals(movieEntity.getImgMoviePoster(), entity.getImgMoviePoster());
        assertEquals(movieEntity.getImgMovieBg(), entity.getImgMovieBg());
        assertEquals(movieEntity.getMovieSynopsis(), entity.getMovieSynopsis());
    }
}