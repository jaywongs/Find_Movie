package com.jay.po;

public class Alstab {
    private Integer userid;

    private Integer movieid;

    private Double rating;

    public Alstab(Integer userid, Integer movieid, Double rating) {
        this.userid = userid;
        this.movieid = movieid;
        this.rating = rating;
    }

    public Alstab() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}