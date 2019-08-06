package com.amary.app.data.jetmovietvcat.ui.movie;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    private MovieViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(jetMovieTvRepository);
    }

    @Test
    public void getMovies() {
        when(jetMovieTvRepository.getAllMovies()).thenReturn(FakeDataDummy.generateDummyMovies());
        List<MovieEntity> movieEntities =viewModel.getMovies();
        verify(jetMovieTvRepository).getAllMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}