package com.eueh.openeye.find.finddetailplayer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class FindDeatailBeanParcelable implements Parcelable {
    private String imageFeed;
    private String title;
    private String description;
    private String category;
    private String palyUrl;
    private int releaseTime;
    private int collectionCount;
    private String authorName;
    private String authorIcon;
    private String authorDescription;
    private String blurred ;

    public String getBlurred() {
        return blurred;
    }

    public FindDeatailBeanParcelable setBlurred(String blurred) {
        this.blurred = blurred;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public FindDeatailBeanParcelable setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getAuthorIcon() {
        return authorIcon;
    }

    public FindDeatailBeanParcelable setAuthorIcon(String authorIcon) {
        this.authorIcon = authorIcon;
        return this;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public FindDeatailBeanParcelable setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
        return this;
    }

    protected FindDeatailBeanParcelable(Parcel in) {
        imageFeed = in.readString();
        title = in.readString();
        description = in.readString();
        category = in.readString();
        palyUrl = in.readString();
        releaseTime = in.readInt();
        collectionCount = in.readInt();
        shareCount = in.readInt();
        replyCount = in.readInt();
        authorName = in.readString();
        authorDescription = in.readString();
        authorIcon = in.readString();
        blurred = in.readString();
    }

    public FindDeatailBeanParcelable() {
    }

    public static final Creator<FindDeatailBeanParcelable> CREATOR = new Creator<FindDeatailBeanParcelable>() {
        @Override
        public FindDeatailBeanParcelable createFromParcel(Parcel in) {
            return new FindDeatailBeanParcelable(in);
        }

        @Override
        public FindDeatailBeanParcelable[] newArray(int size) {
            return new FindDeatailBeanParcelable[size];
        }
    };

    public String getImageFeed() {
        return imageFeed;
    }

    public FindDeatailBeanParcelable setImageFeed(String imageFeed) {
        this.imageFeed = imageFeed;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FindDeatailBeanParcelable setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FindDeatailBeanParcelable setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public FindDeatailBeanParcelable setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getPalyUrl() {
        return palyUrl;
    }

    public FindDeatailBeanParcelable setPalyUrl(String palyUrl) {
        this.palyUrl = palyUrl;
        return this;
    }

    public int getReleaseTime() {
        return releaseTime;
    }

    public FindDeatailBeanParcelable setReleaseTime(int releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public FindDeatailBeanParcelable setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
        return this;
    }

    public int getShareCount() {
        return shareCount;
    }

    public FindDeatailBeanParcelable setShareCount(int shareCount) {
        this.shareCount = shareCount;
        return this;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public FindDeatailBeanParcelable setReplyCount(int replyCount) {
        this.replyCount = replyCount;
        return this;
    }

    private int shareCount;
    private int replyCount;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imageFeed);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(category);
        parcel.writeString(palyUrl);
        parcel.writeInt(releaseTime);
        parcel.writeInt(collectionCount);
        parcel.writeInt(shareCount);
        parcel.writeInt(replyCount);
        parcel.writeString(authorName);
        parcel.writeString(authorDescription);
        parcel.writeString(authorIcon);
        parcel.writeString(blurred);
    }
}
