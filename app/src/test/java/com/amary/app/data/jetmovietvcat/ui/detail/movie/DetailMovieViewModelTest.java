package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =new InstantTaskExecutorRule();

    private DetailMovieViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);
    private MovieEntity movieDummy = FakeDataDummy.generateDummyMovies().get(0);
    private String movieId = movieDummy.getMovieId();

    @Before
    public void setUp(){
        viewModel = new DetailMovieViewModel(jetMovieTvRepository);
        viewModel.setMovieId(movieId);
    }

    @Test
    public void getMovies() {
        MutableLiveData<MovieEntity> movieEntities = new MutableLiveData<>();
        movieEntities.setValue(movieDummy);


        when(jetMovieTvRepository.getDetailMovie(movieId)).thenReturn(movieEntities);

        Observer<MovieEntity> observer = mock(Observer.class);
        viewModel.getMovies().observeForever(observer);

        verify(jetMovieTvRepository).getDetailMovie(movieId);
    }
}