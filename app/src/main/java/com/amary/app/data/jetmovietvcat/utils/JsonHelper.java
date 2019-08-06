package com.amary.app.data.jetmovietvcat.utils;

import android.app.Application;

import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class JsonHelper {

    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName){
        try {
            InputStream stream = application.getAssets().open(fileName);
            byte[] buffer = new byte[stream.available()];
            stream.read(buffer);
            stream.close();
            return new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovies(){
        ArrayList<MovieResponse> list = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(parsingFileToString("MovieResponse.json"));
            JSONArray array = object.getJSONArray("movies");
            for (int i=0; i< array.length();i++){
                JSONObject movies = array.getJSONObject(i);

                String id = movies.getString("id");
                String title = movies.getString("title");
                String date = movies.getString("date");
                String rate = movies.getString("rate");
                String poster = movies.getString("poster");
                String background = movies.getString("background");
                String synopsis = movies.getString("synopsis");

                MovieResponse movieResponse = new MovieResponse(id, title, date, rate, poster, background, synopsis);
                list.add(movieResponse);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TvShowResponse> loadTvShows(){
        ArrayList<TvShowResponse> list = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(parsingFileToString("TvShowsResponse.json"));
            JSONArray array = object.getJSONArray("tvshows");
            for (int i=0; i< array.length();i++){
                JSONObject tvshows = array.getJSONObject(i);

                String id = tvshows.getString("id");
                String title = tvshows.getString("title");
                String date = tvshows.getString("date");
                String rate = tvshows.getString("rate");
                String poster = tvshows.getString("poster");
                String background = tvshows.getString("background");
                String synopsis = tvshows.getString("synopsis");

                TvShowResponse tvShowResponse = new TvShowResponse(id, title, date, rate, poster, background, synopsis);
                list.add(tvShowResponse);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
