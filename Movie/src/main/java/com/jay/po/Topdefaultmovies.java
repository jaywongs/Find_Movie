package com.jay.po;

public class Topdefaultmovies {
    private Integer id;

    private Integer movieid;

    private String moviename;

    public Topdefaultmovies(Integer id, Integer movieid, String moviename) {
        this.id = id;
        this.movieid = movieid;
        this.moviename = moviename;
    }

    public Topdefaultmovies() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename == null ? null : moviename.trim();
    }
}