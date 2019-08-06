package com.amary.app.data.jetmovietvcat.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.amary.app.data.jetmovietvcat.data.source.local.LocalRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.data.source.remote.RemoteRepository;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JetMovieTvRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository localRepository = Mockito.mock(LocalRepository.class);
    private RemoteRepository remoteRepository = Mockito.mock(RemoteRepository.class);
    private FakeJetMovieTvRepository fakeJetMovieTvRepository = new FakeJetMovieTvRepository(localRepository, remoteRepository);

    private ArrayList<MovieResponse> movieResponses = FakeDataDummy.generateRemoteDummyMovies();
    private String movieId = movieResponses.get(0).getId();

    private ArrayList<TvShowResponse> tvShowResponses = FakeDataDummy.generateRemoteDummyTvShows();
    private String tvshowId = tvShowResponses.get(0).getId();

    @Test
    public void getAllMovies(){
        when(remoteRepository.getMovies()).thenReturn(movieResponses);
        ArrayList<MovieEntity> movieEntities = fakeJetMovieTvRepository.getAllMovies();
        verify(remoteRepository).getMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getAllTvShows(){
        when(remoteRepository.getTvShows()).thenReturn(tvShowResponses);
        ArrayList<TvShowEntity> tvShowEntities = fakeJetMovieTvRepository.getAllTvShows();
        verify(remoteRepository).getTvShows();
        assertNotNull(tvShowEntities);
        assertEquals(tvShowResponses.size(), tvShowEntities.size());
    }


}