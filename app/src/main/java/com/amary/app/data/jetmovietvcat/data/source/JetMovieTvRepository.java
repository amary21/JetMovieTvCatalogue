package com.amary.app.data.jetmovietvcat.data.source;

import com.amary.app.data.jetmovietvcat.data.source.local.LocalRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.data.source.remote.RemoteRepository;

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
    public List<MovieEntity> getAllMovies() {
        return null;
    }

    @Override
    public MovieEntity getDetailMovie(String movieId) {
        return null;
    }

    @Override
    public List<TvShowEntity> getAllTvShows() {
        return null;
    }

    @Override
    public TvShowEntity getDetailTvShows(String tvId) {
        return null;
    }
}
