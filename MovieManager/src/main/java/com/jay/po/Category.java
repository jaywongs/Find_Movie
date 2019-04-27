package com.jay.po;

public class Category {
    private Integer categoryid;

    private String category;

    public Category(Integer categoryid, String category) {
        this.categoryid = categoryid;
        this.category = category;
    }

    public Category() {
        super();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}