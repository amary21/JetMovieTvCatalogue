package com.amary.app.data.jetmovietvcat.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collection;

public class MovieResponse implements Parcelable {
    private String id;
    private String title;
    private String date;
    private String rate;
    private String poster;
    private String background;
    private String synopsis;



    public MovieResponse(String id, String title, String date, String rate, String poster, String background, String synopsis) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.rate = rate;
        this.poster = poster;
        this.background = background;
        this.synopsis = synopsis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.rate);
        dest.writeString(this.poster);
        dest.writeString(this.background);
        dest.writeString(this.synopsis);
    }

    public MovieResponse() {
    }

    private MovieResponse(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.date = in.readString();
        this.rate = in.readString();
        this.poster = in.readString();
        this.background = in.readString();
        this.synopsis = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel source) {
            return new MovieResponse(source);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}
