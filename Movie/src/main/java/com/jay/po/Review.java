package com.jay.po;

import java.util.Date;

public class Review {
    private Integer reviewid;

    private Integer userid;

    private Integer movieid;

    private String content;

    private Double star;

    private Date reviewtime;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    private String picture;

    public Review(Integer reviewid, Integer userid, Integer movieid, String content, Double star, Date reviewtime) {
        this.reviewid = reviewid;
        this.userid = userid;
        this.movieid = movieid;
        this.content = content;
        this.star = star;
        this.reviewtime = reviewtime;
    }

    public Review() {
        super();
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }
}