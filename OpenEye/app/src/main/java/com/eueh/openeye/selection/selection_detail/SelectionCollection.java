package com.eueh.openeye.selection.selection_detail;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by 陈焕栋 on 16/12/28.
 */
@Table("selectionCollection")
public class SelectionCollection {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    int id ;
    String picUrl ;
    String title ;
    String category ;
    int releaseTime ;
    boolean isCollect ;
    int collectionCount ;

    public SelectionCollection(String picUrl, String category, int releaseTime , int collectionCount) {
        this.picUrl = picUrl;
        this.category = category;
        this.releaseTime = releaseTime;
    }

    public SelectionCollection() {
    }


    public boolean getisCollect() {
        return isCollect;
    }

    public SelectionCollection setisCollect(boolean collect) {
        isCollect = collect;
        return this;
    }

    public int getId() {
        return id;
    }

    public SelectionCollection setId(int id) {
        this.id = id;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public SelectionCollection setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public SelectionCollection setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getReleaseTime() {
        return releaseTime;
    }

    public SelectionCollection setReleaseTime(int releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public SelectionCollection setCollect(boolean collect) {
        isCollect = collect;
        return this;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public SelectionCollection setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SelectionCollection setTitle(String title) {
        this.title = title;
        return this;
    }
}
