package com.amary.app.data.jetmovietvcat.data.source;

import androidx.annotation.NonNull;

import com.amary.app.data.jetmovietvcat.data.source.local.LocalRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.data.source.remote.RemoteRepository;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeJetMovieTvRepository implements JetMovieTvDataSource{

    private volatile static FakeJetMovieTvRepository INSTANCE = null;

    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;

    FakeJetMovieTvRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public static FakeJetMovieTvRepository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository){
        if (INSTANCE == null){
            synchronized (FakeJetMovieTvRepository.class){
                if (INSTANCE == null){
                    INSTANCE = new FakeJetMovieTvRepository(localRepository, remoteRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public ArrayList<MovieEntity> getAllMovies() {
        List<MovieResponse> movieResponses = remoteRepository.getMovies();
        ArrayList<MovieEntity> movieEntities = new ArrayList<>();
        for (int i =0; i< movieResponses.size(); i++){
            MovieResponse response = movieResponses.get(i);
            MovieEntity entity = new MovieEntity(response.getId(),
                    response.getTitle(),
                    response.getDate(),
                    response.getRate(),
                    response.getPoster(),
                    response.getBackground(),
                    response.getSynopsis());

            movieEntities.add(entity);
        }

        return movieEntities;
    }

    @Override
    public MovieEntity getDetailMovie(String movieId) {
        MovieEntity entity = null;
        List<MovieResponse> movies = remoteRepository.getMovies();
        for (int i=0 ;i<movies.size(); i++){
            MovieResponse response = movies.get(i);
            if (response.getId().equals(movieId)){
                entity = new MovieEntity(response.getId(),
                        response.getTitle(),
                        response.getDate(),
                        response.getRate(),
                        response.getPoster(),
                        response.getBackground(),
                        response.getSynopsis());
            }
        }
        return entity;
    }

    @Override
    public ArrayList<TvShowEntity> getAllTvShows() {
        List<TvShowResponse> tvShowResponses = remoteRepository.getTvShows();
        ArrayList<TvShowEntity> tvShowEntities = new ArrayList<>();
        for (int i =0; i < tvShowResponses.size(); i++){
            TvShowResponse response = tvShowResponses.get(i);
            TvShowEntity entity = new TvShowEntity(response.getId(),
                    response.getTitle(),
                    response.getDate(),
                    response.getRate(),
                    response.getPoster(),
                    response.getBackground(),
                    response.getSynopsis());

            tvShowEntities.add(entity);
        }
        return tvShowEntities;
    }

    @Override
    public TvShowEntity getDetailTvShows(String tvId) {
        TvShowEntity entity = null;
        List<TvShowResponse> tvShows = remoteRepository.getTvShows();
        for (int i=0; i<tvShows.size(); i++){
            TvShowResponse response = tvShows.get(i);
            if (response.getId().equals(tvId)){
                entity = new TvShowEntity(response.getId(),
                        response.getTitle(),
                        response.getDate(),
                        response.getRate(),
                        response.getPoster(),
                        response.getBackground(),
                        response.getSynopsis());
            }
        }

        return entity;
    }
}
