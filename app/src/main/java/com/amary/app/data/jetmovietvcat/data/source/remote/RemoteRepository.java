package com.amary.app.data.jetmovietvcat.data.source.remote;

import android.os.Handler;

import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;
import com.amary.app.data.jetmovietvcat.utils.EspressoIdlingResource;
import com.amary.app.data.jetmovietvcat.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {

    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
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

    public void getMovies(LoadMoviesCallback callback){
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllMoviesReceive(jsonHelper.loadMovies());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShows(LoadTvShowsCallback callback){
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllTvShowsReceive(jsonHelper.loadTvShows());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }


    public interface LoadMoviesCallback{
        void onAllMoviesReceive(List<MovieResponse> movieResponses);

        void onDataNotAvailable();
    }

    public interface LoadTvShowsCallback{
        void onAllTvShowsReceive(List<TvShowResponse> tvShowResponses);

        void onDataNotAvailabe();
    }
}
