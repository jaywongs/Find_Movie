package com.jay.po;

/**
 * created by jaywang on 2019/3/15.
 */
public class SelectQuery {
    private int category;
    private int movieLimit;
    private String sort;

    public int getCategory() {
        return category;
    }

    public void setCategoryId(Integer category) {
        this.category = category;
    }

    public int getMovieLimit() {
        return movieLimit;
    }

    public void setMovieLimit(Integer movieLimit) {
        this.movieLimit = movieLimit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
