package com.amary.app.data.jetmovietvcat.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amary.app.data.jetmovietvcat.data.source.local.LocalRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.data.source.remote.RemoteRepository;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class JetMovieTvRepository implements JetMovieTvDataSource{

    private volatile static JetMovieTvRepository INSTANCE = null;

    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;

    private JetMovieTvRepository(LocalRepository localRepository, RemoteRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public static JetMovieTvRepository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository){
        if (INSTANCE == null){
            synchronized (JetMovieTvRepository.class){
                if (INSTANCE == null){
                    INSTANCE = new JetMovieTvRepository(localRepository, remoteRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieEntity>> getAllMovies() {
        MutableLiveData<List<MovieEntity>> moviesEntities = new MutableLiveData<>();
        remoteRepository.getMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceive(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> movieList = new ArrayList<>();
                for (int i =0; i< movieResponses.size(); i++){
                    MovieResponse response = movieResponses.get(i);
                    MovieEntity entity = new MovieEntity(response.getId(),
                            response.getTitle(),
                            response.getDate(),
                            response.getRate(),
                            response.getPoster(),
                            response.getBackground(),
                            response.getSynopsis());

                    movieList.add(entity);
                }
                moviesEntities.postValue(movieList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return moviesEntities;
    }

    @Override
    public LiveData<MovieEntity> getDetailMovie(final String movieId) {
        MutableLiveData<MovieEntity> movieEntites = new MutableLiveData<>();
        remoteRepository.getMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceive(List<MovieResponse> movieResponses) {
                for (int i=0 ;i < movieResponses.size(); i++){
                    MovieResponse response = movieResponses.get(i);
                    if (response.getId().equals(movieId)){
                        MovieEntity entity = new MovieEntity(response.getId(),
                                            response.getTitle(),
                                            response.getDate(),
                                            response.getRate(),
                                            response.getPoster(),
                                            response.getBackground(),
                                            response.getSynopsis());
                        movieEntites.postValue(entity);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return movieEntites;
    }

    @Override
    public LiveData<List<TvShowEntity>> getAllTvShows() {
        MutableLiveData<List<TvShowEntity>> tvShowEntities = new MutableLiveData<>();
        remoteRepository.getTvShows(new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onAllTvShowsReceive(List<TvShowResponse> tvShowResponses) {
                ArrayList<TvShowEntity> tvShowsList = new ArrayList<>();
                for (int i =0; i < tvShowResponses.size(); i++){
                    TvShowResponse response = tvShowResponses.get(i);
                    TvShowEntity entity = new TvShowEntity(response.getId(),
                            response.getTitle(),
                            response.getDate(),
                            response.getRate(),
                            response.getPoster(),
                            response.getBackground(),
                            response.getSynopsis());

                    tvShowsList.add(entity);
                }
                tvShowEntities.postValue(tvShowsList);
            }

            @Override
            public void onDataNotAvailabe() {

            }
        });

        return tvShowEntities;
    }

    @Override
    public LiveData<TvShowEntity> getDetailTvShows(final String tvId) {
        MutableLiveData<TvShowEntity> tvShowEntities = new MutableLiveData<>();
        remoteRepository.getTvShows(new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onAllTvShowsReceive(List<TvShowResponse> tvShowResponses) {
                for (int i=0; i<tvShowResponses.size(); i++){
                    TvShowResponse response = tvShowResponses.get(i);
                    if (response.getId().equals(tvId)){
                        TvShowEntity entity = new TvShowEntity(response.getId(),
                                            response.getTitle(),
                                            response.getDate(),
                                            response.getRate(),
                                            response.getPoster(),
                                            response.getBackground(),
                                            response.getSynopsis());
                        tvShowEntities.postValue(entity);
                    }
                }
            }

            @Override
            public void onDataNotAvailabe() {

            }
        });


        return tvShowEntities;
    }
}
