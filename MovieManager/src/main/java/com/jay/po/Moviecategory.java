package com.jay.po;

public class Moviecategory {
    private Integer movcatid;

    private Integer movieid;

    private Integer categoryid;

    public Moviecategory(Integer movcatid, Integer movieid, Integer categoryid) {
        this.movcatid = movcatid;
        this.movieid = movieid;
        this.categoryid = categoryid;
    }

    public Moviecategory() {
        super();
    }

    public Integer getMovcatid() {
        return movcatid;
    }

    public void setMovcatid(Integer movcatid) {
        this.movcatid = movcatid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
}