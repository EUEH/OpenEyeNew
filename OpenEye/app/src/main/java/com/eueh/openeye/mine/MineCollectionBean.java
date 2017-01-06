package com.eueh.openeye.mine;

/**
 * Created by 陈焕栋 on 17/1/3.
 */

public class MineCollectionBean {
    private String urlPic , category , title ;
    private int releaseTime ;

    public MineCollectionBean() {
    }



    public String getUrlPic() {
        return urlPic;
    }

    public MineCollectionBean setUrlPic(String urlPic) {
        this.urlPic = urlPic;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public MineCollectionBean setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MineCollectionBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getReleaseTime() {
        return releaseTime;
    }

    public MineCollectionBean setReleaseTime(int releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }
}
