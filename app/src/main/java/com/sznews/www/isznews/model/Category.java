package com.sznews.www.isznews.model;

/**
 * Created by sznews on 2016/12/2.
 */

public class Category {
    private Integer catid;
    private String catname;
    private String iconurl;
    private String name;
    private String url;

    public Category(String catname){
//        setCatid(catid);
        setCatname(catname);
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
