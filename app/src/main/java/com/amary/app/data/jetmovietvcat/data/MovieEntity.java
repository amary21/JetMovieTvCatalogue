package com.amary.app.data.jetmovietvcat.data;

public class MovieEntity {
    private String movieId;
    private String movieTitle;
    private String movieDate;
    private String movieRate;
    private String imgMoviePoster;
    private String imgMovieBg;
    private String movieSynopsis;

    public MovieEntity(String movieId, String movieTitle, String movieDate, String movieRate, String imgMoviePoster, String imgMovieBg, String movieSynopsis) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieDate = movieDate;
        this.movieRate = movieRate;
        this.imgMoviePoster = imgMoviePoster;
        this.imgMovieBg = imgMovieBg;
        this.movieSynopsis = movieSynopsis;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public String getMovieRate() {
        return movieRate;
    }

    public String getImgMoviePoster() {
        return imgMoviePoster;
    }

    public String getImgMovieBg() {
        return imgMovieBg;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

}
