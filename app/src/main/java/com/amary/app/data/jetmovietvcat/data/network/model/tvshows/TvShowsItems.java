package com.amary.app.data.jetmovietvcat.data.network.model.tvshows;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvShowsItems implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("overview")
    @Expose
    private String overview;

    public String getName() {
        return name;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public Integer getId() {
        return id;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOverview() {
        return overview;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.firstAirDate);
        dest.writeValue(this.id);
        dest.writeValue(this.voteAverage);
        dest.writeString(this.posterPath);
        dest.writeString(this.backdropPath);
        dest.writeString(this.overview);
    }

    public TvShowsItems() {
    }

    protected TvShowsItems(Parcel in) {
        this.name = in.readString();
        this.firstAirDate = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
        this.overview = in.readString();
    }

    public static final Parcelable.Creator<TvShowsItems> CREATOR = new Parcelable.Creator<TvShowsItems>() {
        @Override
        public TvShowsItems createFromParcel(Parcel source) {
            return new TvShowsItems(source);
        }

        @Override
        public TvShowsItems[] newArray(int size) {
            return new TvShowsItems[size];
        }
    };
}
