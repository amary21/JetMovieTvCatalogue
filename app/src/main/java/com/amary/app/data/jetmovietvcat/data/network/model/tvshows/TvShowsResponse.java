package com.amary.app.data.jetmovietvcat.data.network.model.tvshows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvShowsResponse {
    @SerializedName("results")
    @Expose
    private ArrayList<TvShowsItems> results = null;

    public ArrayList<TvShowsItems> getResults() {
        return results;
    }
}
