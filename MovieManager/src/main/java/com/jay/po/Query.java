package com.jay.po;

/**
 * created by jaywang on 2019/5/11.
 */
public class Query {
    private String movieName;

    private int CategoryId;

    //当前页
    private Integer page;

    //每行数
    private Integer size = 5;

    //起始行
    private Integer startRow = 0;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
