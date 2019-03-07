package com.jay.po;

public class Rectab {
    private Integer userid;

    private String movieids;

    public Rectab(Integer userid, String movieids) {
        this.userid = userid;
        this.movieids = movieids;
    }

    public Rectab() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMovieids() {
        return movieids;
    }

    public void setMovieids(String movieids) {
        this.movieids = movieids == null ? null : movieids.trim();
    }
}