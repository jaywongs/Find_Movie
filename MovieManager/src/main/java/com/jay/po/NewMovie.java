package com.jay.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewMovie {
    private Integer movieid;

    private String moviename;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date showyear;

    private String nation;

    private String director;

    private String leadactors;

    private String screenwriter;

    private String picture;

    private Double averating;

    private Integer numrating;

    private String description;

    private Integer [] categoryid;

    private String categoryname;

    public Integer[] getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer[] categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public NewMovie(Integer movieid, String moviename, Date showyear, String nation, String director, String leadactors, String screenwriter, String picture, Double averating, Integer numrating, String description) {
        this.movieid = movieid;
        this.moviename = moviename;
        this.showyear = showyear;
        this.nation = nation;
        this.director = director;
        this.leadactors = leadactors;
        this.screenwriter = screenwriter;
        this.picture = picture;
        this.averating = averating;
        this.numrating = numrating;
        this.description = description;
    }

    public NewMovie() {
        super();
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

    public Date getShowyear() {
        return showyear;
    }

    public void setShowyear(Date showyear) {
        this.showyear = showyear;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getLeadactors() {
        return leadactors;
    }

    public void setLeadactors(String leadactors) {
        this.leadactors = leadactors == null ? null : leadactors.trim();
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter == null ? null : screenwriter.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Double getAverating() {
        return averating;
    }

    public void setAverating(Double averating) {
        this.averating = averating;
    }

    public Integer getNumrating() {
        return numrating;
    }

    public void setNumrating(Integer numrating) {
        this.numrating = numrating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}