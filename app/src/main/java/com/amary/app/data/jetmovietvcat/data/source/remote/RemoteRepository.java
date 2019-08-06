package com.amary.app.data.jetmovietvcat.data.source.remote;

import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;
import com.amary.app.data.jetmovietvcat.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper){
        if (INSTANCE == null){
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public List<MovieResponse> getMovies(){
        return jsonHelper.loadMovies();
    }

    public List<TvShowResponse> getTvShows(){
        return jsonHelper.loadTvShows();
    }
}
