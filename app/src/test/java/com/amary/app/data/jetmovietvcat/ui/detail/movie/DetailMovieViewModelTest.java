package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);
    private MovieEntity movieEntity = FakeDataDummy.generateDummyMovies().get(0);
    private String movieId = movieEntity.getMovieId();

    @Before
    public void setUp(){
        viewModel = new DetailMovieViewModel(jetMovieTvRepository);
        viewModel.setMovieId(movieId);
    }

    @Test
    public void getMovies() {
        when(jetMovieTvRepository.getDetailMovie(movieId)).thenReturn(movieEntity);
        MovieEntity entity = viewModel.getMovies();
        verify(jetMovieTvRepository).getDetailMovie(movieId);
        assertNotNull(entity);

        assertNotNull(entity.getMovieId());
        assertNotNull(entity.getMovieTitle());
        assertNotNull(entity.getMovieDate());
        assertNotNull(entity.getMovieRate());
        assertNotNull(entity.getImgMoviePoster());
        assertNotNull(entity.getImgMovieBg());
        assertNotNull(entity.getMovieSynopsis());

        assertEquals(movieEntity.getMovieId(), entity.getMovieId());
        assertEquals(movieEntity.getMovieTitle(), entity.getMovieTitle());
        assertEquals(movieEntity.getMovieDate(), entity.getMovieDate());
        assertEquals(movieEntity.getMovieRate(), entity.getMovieRate());
        assertEquals(movieEntity.getImgMoviePoster(), entity.getImgMoviePoster());
        assertEquals(movieEntity.getImgMovieBg(), entity.getImgMovieBg());
        assertEquals(movieEntity.getMovieSynopsis(), entity.getMovieSynopsis());
    }
}