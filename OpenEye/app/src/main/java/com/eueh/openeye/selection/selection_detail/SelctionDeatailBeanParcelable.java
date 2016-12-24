package com.eueh.openeye.selection.selection_detail;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class SelctionDeatailBeanParcelable implements Parcelable {
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

    public SelctionDeatailBeanParcelable setBlurred(String blurred) {
        this.blurred = blurred;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public SelctionDeatailBeanParcelable setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getAuthorIcon() {
        return authorIcon;
    }

    public SelctionDeatailBeanParcelable setAuthorIcon(String authorIcon) {
        this.authorIcon = authorIcon;
        return this;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public SelctionDeatailBeanParcelable setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
        return this;
    }

    protected SelctionDeatailBeanParcelable(Parcel in) {
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

    public SelctionDeatailBeanParcelable() {
    }

    public static final Creator<SelctionDeatailBeanParcelable> CREATOR = new Creator<SelctionDeatailBeanParcelable>() {
        @Override
        public SelctionDeatailBeanParcelable createFromParcel(Parcel in) {
            return new SelctionDeatailBeanParcelable(in);
        }

        @Override
        public SelctionDeatailBeanParcelable[] newArray(int size) {
            return new SelctionDeatailBeanParcelable[size];
        }
    };

    public String getImageFeed() {
        return imageFeed;
    }

    public SelctionDeatailBeanParcelable setImageFeed(String imageFeed) {
        this.imageFeed = imageFeed;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SelctionDeatailBeanParcelable setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SelctionDeatailBeanParcelable setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public SelctionDeatailBeanParcelable setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getPalyUrl() {
        return palyUrl;
    }

    public SelctionDeatailBeanParcelable setPalyUrl(String palyUrl) {
        this.palyUrl = palyUrl;
        return this;
    }

    public int getReleaseTime() {
        return releaseTime;
    }

    public SelctionDeatailBeanParcelable setReleaseTime(int releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public SelctionDeatailBeanParcelable setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
        return this;
    }

    public int getShareCount() {
        return shareCount;
    }

    public SelctionDeatailBeanParcelable setShareCount(int shareCount) {
        this.shareCount = shareCount;
        return this;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public SelctionDeatailBeanParcelable setReplyCount(int replyCount) {
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
