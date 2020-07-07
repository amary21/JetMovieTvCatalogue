package com.amary.app.data.jetmovietvcat.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.amary.app.data.jetmovietvcat.data.source.local.LocalRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.data.source.remote.RemoteRepository;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;
import com.amary.app.data.jetmovietvcat.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback)invocation.getArguments()[0])
                    .onAllMoviesReceive(movieResponses);
            return null;
        }).when(remoteRepository).getMovies(any(RemoteRepository.LoadMoviesCallback.class));

        List<MovieEntity> movieEntities = LiveDataTestUtil.getValue(fakeJetMovieTvRepository.getAllMovies());

        verify(remoteRepository, times(1)).getMovies(any(RemoteRepository.LoadMoviesCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getAllTvShows(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowsCallback)invocation.getArguments()[0])
                    .onAllTvShowsReceive(tvShowResponses);
            return null;
        }).when(remoteRepository).getTvShows(any(RemoteRepository.LoadTvShowsCallback.class));

        List<TvShowEntity> tvShowEntities = LiveDataTestUtil.getValue(fakeJetMovieTvRepository.getAllTvShows());
        verify(remoteRepository, times(1)).getTvShows(any(RemoteRepository.LoadTvShowsCallback.class));
        assertNotNull(tvShowEntities);
        assertEquals(tvShowResponses.size(), tvShowEntities.size());
    }

    @Test
    public void getDetailMovie(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0])
                    .onAllMoviesReceive(movieResponses);
            return null;
        }).when(remoteRepository).getMovies(any(RemoteRepository.LoadMoviesCallback.class));

        MovieEntity entity = LiveDataTestUtil.getValue(fakeJetMovieTvRepository.getDetailMovie(movieId));

        verify(remoteRepository, times(1)).getMovies(any(RemoteRepository.LoadMoviesCallback.class));

        assertNotNull(entity);
        assertEquals(movieResponses.get(0).getTitle(), entity.getMovieTitle());
        assertEquals(movieResponses.get(0).getDate(), entity.getMovieDate());
        assertEquals(movieResponses.get(0).getRate(), entity.getMovieRate());
        assertEquals(movieResponses.get(0).getPoster(), entity.getImgMoviePoster());
        assertEquals(movieResponses.get(0).getBackground(), entity.getImgMovieBg());
        assertEquals(movieResponses.get(0).getSynopsis(), entity.getMovieSynopsis());
    }

    @Test
    public void getDetailTvShows(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowsCallback) invocation.getArguments()[0])
                    .onAllTvShowsReceive(tvShowResponses);
            return null;
        }).when(remoteRepository).getTvShows(any(RemoteRepository.LoadTvShowsCallback.class));

        TvShowEntity entity = LiveDataTestUtil.getValue(fakeJetMovieTvRepository.getDetailTvShows(tvshowId));

        verify(remoteRepository, times(1)).getTvShows(any(RemoteRepository.LoadTvShowsCallback.class));

        assertNotNull(entity);
        assertEquals(tvShowResponses.get(0).getTitle(), entity.getTvTitle());
        assertEquals(tvShowResponses.get(0).getDate(), entity.getTvDate());
        assertEquals(tvShowResponses.get(0).getRate(), entity.getTvRate());
        assertEquals(tvShowResponses.get(0).getPoster(), entity.getImgTvPoster());
        assertEquals(tvShowResponses.get(0).getBackground(), entity.getImgTvBg());
        assertEquals(tvShowResponses.get(0).getSynopsis(), entity.getTvSynopsis());
    }


}