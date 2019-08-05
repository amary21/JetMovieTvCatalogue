package com.amary.app.data.jetmovietvcat.data.network;

import com.amary.app.data.jetmovietvcat.data.network.model.movies.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.network.model.tvshows.TvShowsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("movie/now_playing")
    Observable<MovieResponse> getMainMovie(
            @Query("api_key") String api_key,
            @Query("language") String language);

    @GET("tv/on_the_air")
    Observable<TvShowsResponse> getMainTv(
            @Query("api_key") String api_key,
            @Query("language") String language);
}
