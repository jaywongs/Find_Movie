package com.jay.po;

public class Similartab {
    private Double similar;

    private String itemid1;

    private String itemid2;

    public Similartab(Double similar, String itemid1, String itemid2) {
        this.similar = similar;
        this.itemid1 = itemid1;
        this.itemid2 = itemid2;
    }

    public Similartab() {
        super();
    }

    public Double getSimilar() {
        return similar;
    }

    public void setSimilar(Double similar) {
        this.similar = similar;
    }

    public String getItemid1() {
        return itemid1;
    }

    public void setItemid1(String itemid1) {
        this.itemid1 = itemid1 == null ? null : itemid1.trim();
    }

    public String getItemid2() {
        return itemid2;
    }

    public void setItemid2(String itemid2) {
        this.itemid2 = itemid2 == null ? null : itemid2.trim();
    }
}