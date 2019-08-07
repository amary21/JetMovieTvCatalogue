package com.amary.app.data.jetmovietvcat.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
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

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private JetMovieTvRepository jetMovieTvRepository = mock(JetMovieTvRepository.class);

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(jetMovieTvRepository);
    }

    @Test
    public void getMovies() {
        MutableLiveData<List<MovieEntity>> movieEntities =new MutableLiveData<>();
        movieEntities.setValue(FakeDataDummy.generateDummyMovies());
        when(jetMovieTvRepository.getAllMovies()).thenReturn(movieEntities);
        Observer<List<MovieEntity>> observer = Mockito.mock(Observer.class);
        viewModel.getMovies().observeForever(observer);
        verify(jetMovieTvRepository).getAllMovies();
    }
}