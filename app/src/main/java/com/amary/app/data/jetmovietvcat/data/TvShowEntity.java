package com.amary.app.data.jetmovietvcat.data;

public class TvShowEntity {
    private String tvId;
    private String tvTitle;
    private String tvDate;
    private String tvRate;
    private String imgTvPoster;
    private String imgTvBg;
    private String tvSynopsis;

    public TvShowEntity(String tvId, String tvTitle, String tvDate, String tvRate, String imgTvPoster, String imgTvBg, String tvSynopsis) {
        this.tvId = tvId;
        this.tvTitle = tvTitle;
        this.tvDate = tvDate;
        this.tvRate = tvRate;
        this.imgTvPoster = imgTvPoster;
        this.imgTvBg = imgTvBg;
        this.tvSynopsis = tvSynopsis;
    }

    public String getTvId() {
        return tvId;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public String getTvDate() {
        return tvDate;
    }

    public String getTvRate() {
        return tvRate;
    }

    public String getImgTvPoster() {
        return imgTvPoster;
    }

    public String getImgTvBg() {
        return imgTvBg;
    }

    public String getTvSynopsis() {
        return tvSynopsis;
    }

}
