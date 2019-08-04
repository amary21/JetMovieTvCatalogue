package com.amary.app.data.jetmovietvcat.data.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {
    @SerializedName("results")
    @Expose
    private ArrayList<MovieItems> results = null;

    public ArrayList<MovieItems> getResults() {
        return results;
    }
}
