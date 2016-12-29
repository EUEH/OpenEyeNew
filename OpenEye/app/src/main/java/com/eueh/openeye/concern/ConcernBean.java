package com.eueh.openeye.concern;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/20.
 */

public class ConcernBean implements Parcelable{



    private int count;
    private int total;
    private String nextPageUrl;
    private Object updateTime;
    private List<ItemListBeanX> itemList;

    protected ConcernBean(Parcel in) {
        count = in.readInt();
        total = in.readInt();
        nextPageUrl = in.readString();
        itemList = in.createTypedArrayList(ItemListBeanX.CREATOR);
    }

    public static final Creator<ConcernBean> CREATOR = new Creator<ConcernBean>() {
        @Override
        public ConcernBean createFromParcel(Parcel in) {
            return new ConcernBean(in);
        }

        @Override
        public ConcernBean[] newArray(int size) {
            return new ConcernBean[size];
        }
    };

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public List<ItemListBeanX> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(count);
        parcel.writeInt(total);
        parcel.writeString(nextPageUrl);
        parcel.writeTypedList(itemList);
    }

    public static class ItemListBeanX implements Parcelable {


        private String type;
        private DataBeanX data;

        protected ItemListBeanX(Parcel in) {
            type = in.readString();
            data = in.readParcelable(DataBeanX.class.getClassLoader());
        }

        public static final Creator<ItemListBeanX> CREATOR = new Creator<ItemListBeanX>() {
            @Override
            public ItemListBeanX createFromParcel(Parcel in) {
                return new ItemListBeanX(in);
            }

            @Override
            public ItemListBeanX[] newArray(int size) {
                return new ItemListBeanX[size];
            }
        };

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBeanX getData() {
            return data;
        }

        public void setData(DataBeanX data) {
            this.data = data;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(type);
            parcel.writeParcelable(data, i);
        }

        public static class DataBeanX implements Parcelable {


            private String dataType;
            private HeaderBean header;
            private int count;
            private Object adTrack;
            private List<ItemListBean> itemList;

            protected DataBeanX(Parcel in) {
                dataType = in.readString();
                header = in.readParcelable(HeaderBean.class.getClassLoader());
                count = in.readInt();
                itemList = in.createTypedArrayList(ItemListBean.CREATOR);
            }

            public static final Creator<DataBeanX> CREATOR = new Creator<DataBeanX>() {
                @Override
                public DataBeanX createFromParcel(Parcel in) {
                    return new DataBeanX(in);
                }

                @Override
                public DataBeanX[] newArray(int size) {
                    return new DataBeanX[size];
                }
            };

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(dataType);
                parcel.writeParcelable(header, i);
                parcel.writeInt(count);
                parcel.writeTypedList(itemList);
            }

            public static class HeaderBean implements Parcelable {


                private int id;
                private String icon;
                private String iconType;
                private String title;
                private Object subTitle;
                private String description;
                private String actionUrl;
                private Object adTrack;
                private FollowBean follow;

                protected HeaderBean(Parcel in) {
                    id = in.readInt();
                    icon = in.readString();
                    iconType = in.readString();
                    title = in.readString();
                    description = in.readString();
                    actionUrl = in.readString();
                    follow = in.readParcelable(FollowBean.class.getClassLoader());
                }

                public static final Creator<HeaderBean> CREATOR = new Creator<HeaderBean>() {
                    @Override
                    public HeaderBean createFromParcel(Parcel in) {
                        return new HeaderBean(in);
                    }

                    @Override
                    public HeaderBean[] newArray(int size) {
                        return new HeaderBean[size];
                    }
                };

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getIconType() {
                    return iconType;
                }

                public void setIconType(String iconType) {
                    this.iconType = iconType;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public Object getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(Object subTitle) {
                    this.subTitle = subTitle;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public FollowBean getFollow() {
                    return follow;
                }

                public void setFollow(FollowBean follow) {
                    this.follow = follow;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeInt(id);
                    parcel.writeString(icon);
                    parcel.writeString(iconType);
                    parcel.writeString(title);
                    parcel.writeString(description);
                    parcel.writeString(actionUrl);
                    parcel.writeParcelable(follow, i);
                }

                public static class FollowBean implements Parcelable {


                    private String itemType;
                    private int itemId;
                    private boolean followed;

                    protected FollowBean(Parcel in) {
                        itemType = in.readString();
                        itemId = in.readInt();
                        followed = in.readByte() != 0;
                    }

                    public static final Creator<FollowBean> CREATOR = new Creator<FollowBean>() {
                        @Override
                        public FollowBean createFromParcel(Parcel in) {
                            return new FollowBean(in);
                        }

                        @Override
                        public FollowBean[] newArray(int size) {
                            return new FollowBean[size];
                        }
                    };

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isFollowed() {
                        return followed;
                    }

                    public void setFollowed(boolean followed) {
                        this.followed = followed;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel parcel, int i) {
                        parcel.writeString(itemType);
                        parcel.writeInt(itemId);
                        parcel.writeByte((byte) (followed ? 1 : 0));
                    }
                }
            }

            public static class ItemListBean implements Parcelable {


                private String type;
                private DataBean data;

                protected ItemListBean(Parcel in) {
                    type = in.readString();
                    data = in.readParcelable(DataBean.class.getClassLoader());
                }

                public static final Creator<ItemListBean> CREATOR = new Creator<ItemListBean>() {
                    @Override
                    public ItemListBean createFromParcel(Parcel in) {
                        return new ItemListBean(in);
                    }

                    @Override
                    public ItemListBean[] newArray(int size) {
                        return new ItemListBean[size];
                    }
                };

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public DataBean getData() {
                    return data;
                }

                public void setData(DataBean data) {
                    this.data = data;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(type);
                    parcel.writeParcelable(data, i);
                }

                public static class DataBean implements Parcelable {


                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    private ProviderBean provider;
                    private String category;
                    private AuthorBean author;
                    private CoverBean cover;
                    private String playUrl;
                    private int duration;
                    private WebUrlBean webUrl;
                    private long releaseTime;
                    private ConsumptionBean consumption;
                    private Object campaign;
                    private Object waterMarks;
                    private Object adTrack;
                    private String type;
                    private int idx;
                    private Object shareAdTrack;
                    private Object favoriteAdTrack;
                    private Object webAdTrack;
                    private long date;
                    private Object promotion;
                    private Object label;
                    private boolean collected;
                    private boolean played;
                    private List<PlayInfoBean> playInfo;
                    private List<?> tags;

                    protected DataBean(Parcel in) {
                        dataType = in.readString();
                        id = in.readInt();
                        title = in.readString();
                        description = in.readString();
                        provider = in.readParcelable(ProviderBean.class.getClassLoader());
                        category = in.readString();
                        author = in.readParcelable(AuthorBean.class.getClassLoader());
                        cover = in.readParcelable(CoverBean.class.getClassLoader());
                        playUrl = in.readString();
                        duration = in.readInt();
                        webUrl = in.readParcelable(WebUrlBean.class.getClassLoader());
                        releaseTime = in.readLong();
                        consumption = in.readParcelable(ConsumptionBean.class.getClassLoader());
                        type = in.readString();
                        idx = in.readInt();
                        date = in.readLong();
                        collected = in.readByte() != 0;
                        played = in.readByte() != 0;
                        playInfo = in.createTypedArrayList(PlayInfoBean.CREATOR);
                    }

                    public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
                        @Override
                        public DataBean createFromParcel(Parcel in) {
                            return new DataBean(in);
                        }

                        @Override
                        public DataBean[] newArray(int size) {
                            return new DataBean[size];
                        }
                    };

                    public String getDataType() {
                        return dataType;
                    }

                    public void setDataType(String dataType) {
                        this.dataType = dataType;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public ProviderBean getProvider() {
                        return provider;
                    }

                    public void setProvider(ProviderBean provider) {
                        this.provider = provider;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public AuthorBean getAuthor() {
                        return author;
                    }

                    public void setAuthor(AuthorBean author) {
                        this.author = author;
                    }

                    public CoverBean getCover() {
                        return cover;
                    }

                    public void setCover(CoverBean cover) {
                        this.cover = cover;
                    }

                    public String getPlayUrl() {
                        return playUrl;
                    }

                    public void setPlayUrl(String playUrl) {
                        this.playUrl = playUrl;
                    }

                    public int getDuration() {
                        return duration;
                    }

                    public void setDuration(int duration) {
                        this.duration = duration;
                    }

                    public WebUrlBean getWebUrl() {
                        return webUrl;
                    }

                    public void setWebUrl(WebUrlBean webUrl) {
                        this.webUrl = webUrl;
                    }

                    public long getReleaseTime() {
                        return releaseTime;
                    }

                    public void setReleaseTime(long releaseTime) {
                        this.releaseTime = releaseTime;
                    }

                    public ConsumptionBean getConsumption() {
                        return consumption;
                    }

                    public void setConsumption(ConsumptionBean consumption) {
                        this.consumption = consumption;
                    }

                    public Object getCampaign() {
                        return campaign;
                    }

                    public void setCampaign(Object campaign) {
                        this.campaign = campaign;
                    }

                    public Object getWaterMarks() {
                        return waterMarks;
                    }

                    public void setWaterMarks(Object waterMarks) {
                        this.waterMarks = waterMarks;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public int getIdx() {
                        return idx;
                    }

                    public void setIdx(int idx) {
                        this.idx = idx;
                    }

                    public Object getShareAdTrack() {
                        return shareAdTrack;
                    }

                    public void setShareAdTrack(Object shareAdTrack) {
                        this.shareAdTrack = shareAdTrack;
                    }

                    public Object getFavoriteAdTrack() {
                        return favoriteAdTrack;
                    }

                    public void setFavoriteAdTrack(Object favoriteAdTrack) {
                        this.favoriteAdTrack = favoriteAdTrack;
                    }

                    public Object getWebAdTrack() {
                        return webAdTrack;
                    }

                    public void setWebAdTrack(Object webAdTrack) {
                        this.webAdTrack = webAdTrack;
                    }

                    public long getDate() {
                        return date;
                    }

                    public void setDate(long date) {
                        this.date = date;
                    }

                    public Object getPromotion() {
                        return promotion;
                    }

                    public void setPromotion(Object promotion) {
                        this.promotion = promotion;
                    }

                    public Object getLabel() {
                        return label;
                    }

                    public void setLabel(Object label) {
                        this.label = label;
                    }

                    public boolean isCollected() {
                        return collected;
                    }

                    public void setCollected(boolean collected) {
                        this.collected = collected;
                    }

                    public boolean isPlayed() {
                        return played;
                    }

                    public void setPlayed(boolean played) {
                        this.played = played;
                    }

                    public List<PlayInfoBean> getPlayInfo() {
                        return playInfo;
                    }

                    public void setPlayInfo(List<PlayInfoBean> playInfo) {
                        this.playInfo = playInfo;
                    }

                    public List<?> getTags() {
                        return tags;
                    }

                    public void setTags(List<?> tags) {
                        this.tags = tags;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel parcel, int i) {
                        parcel.writeString(dataType);
                        parcel.writeInt(id);
                        parcel.writeString(title);
                        parcel.writeString(description);
                        parcel.writeParcelable(provider, i);
                        parcel.writeString(category);
                        parcel.writeParcelable(author, i);
                        parcel.writeParcelable(cover, i);
                        parcel.writeString(playUrl);
                        parcel.writeInt(duration);
                        parcel.writeParcelable(webUrl, i);
                        parcel.writeLong(releaseTime);
                        parcel.writeParcelable(consumption, i);
                        parcel.writeString(type);
                        parcel.writeInt(idx);
                        parcel.writeLong(date);
                        parcel.writeByte((byte) (collected ? 1 : 0));
                        parcel.writeByte((byte) (played ? 1 : 0));
                        parcel.writeTypedList(playInfo);
                    }

                    public static class ProviderBean implements Parcelable {


                        private String name;
                        private String alias;
                        private String icon;

                        protected ProviderBean(Parcel in) {
                            name = in.readString();
                            alias = in.readString();
                            icon = in.readString();
                        }

                        public static final Creator<ProviderBean> CREATOR = new Creator<ProviderBean>() {
                            @Override
                            public ProviderBean createFromParcel(Parcel in) {
                                return new ProviderBean(in);
                            }

                            @Override
                            public ProviderBean[] newArray(int size) {
                                return new ProviderBean[size];
                            }
                        };

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getAlias() {
                            return alias;
                        }

                        public void setAlias(String alias) {
                            this.alias = alias;
                        }

                        public String getIcon() {
                            return icon;
                        }

                        public void setIcon(String icon) {
                            this.icon = icon;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i) {
                            parcel.writeString(name);
                            parcel.writeString(alias);
                            parcel.writeString(icon);
                        }
                    }

                    public static class AuthorBean implements Parcelable {


                        private int id;
                        private String icon;
                        private String name;
                        private String description;
                        private String link;
                        private long latestReleaseTime;
                        private int videoNum;
                        private Object adTrack;
                        private FollowBeanX follow;

                        protected AuthorBean(Parcel in) {
                            id = in.readInt();
                            icon = in.readString();
                            name = in.readString();
                            description = in.readString();
                            link = in.readString();
                            latestReleaseTime = in.readLong();
                            videoNum = in.readInt();
                            follow = in.readParcelable(FollowBeanX.class.getClassLoader());
                        }

                        public static final Creator<AuthorBean> CREATOR = new Creator<AuthorBean>() {
                            @Override
                            public AuthorBean createFromParcel(Parcel in) {
                                return new AuthorBean(in);
                            }

                            @Override
                            public AuthorBean[] newArray(int size) {
                                return new AuthorBean[size];
                            }
                        };

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getIcon() {
                            return icon;
                        }

                        public void setIcon(String icon) {
                            this.icon = icon;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public String getLink() {
                            return link;
                        }

                        public void setLink(String link) {
                            this.link = link;
                        }

                        public long getLatestReleaseTime() {
                            return latestReleaseTime;
                        }

                        public void setLatestReleaseTime(long latestReleaseTime) {
                            this.latestReleaseTime = latestReleaseTime;
                        }

                        public int getVideoNum() {
                            return videoNum;
                        }

                        public void setVideoNum(int videoNum) {
                            this.videoNum = videoNum;
                        }

                        public Object getAdTrack() {
                            return adTrack;
                        }

                        public void setAdTrack(Object adTrack) {
                            this.adTrack = adTrack;
                        }

                        public FollowBeanX getFollow() {
                            return follow;
                        }

                        public void setFollow(FollowBeanX follow) {
                            this.follow = follow;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i) {
                            parcel.writeInt(id);
                            parcel.writeString(icon);
                            parcel.writeString(name);
                            parcel.writeString(description);
                            parcel.writeString(link);
                            parcel.writeLong(latestReleaseTime);
                            parcel.writeInt(videoNum);
                            parcel.writeParcelable(follow, i);
                        }

                        public static class FollowBeanX implements Parcelable {


                            private String itemType;
                            private int itemId;
                            private boolean followed;

                            protected FollowBeanX(Parcel in) {
                                itemType = in.readString();
                                itemId = in.readInt();
                                followed = in.readByte() != 0;
                            }

                            public static final Creator<FollowBeanX> CREATOR = new Creator<FollowBeanX>() {
                                @Override
                                public FollowBeanX createFromParcel(Parcel in) {
                                    return new FollowBeanX(in);
                                }

                                @Override
                                public FollowBeanX[] newArray(int size) {
                                    return new FollowBeanX[size];
                                }
                            };

                            public String getItemType() {
                                return itemType;
                            }

                            public void setItemType(String itemType) {
                                this.itemType = itemType;
                            }

                            public int getItemId() {
                                return itemId;
                            }

                            public void setItemId(int itemId) {
                                this.itemId = itemId;
                            }

                            public boolean isFollowed() {
                                return followed;
                            }

                            public void setFollowed(boolean followed) {
                                this.followed = followed;
                            }

                            @Override
                            public int describeContents() {
                                return 0;
                            }

                            @Override
                            public void writeToParcel(Parcel parcel, int i) {
                                parcel.writeString(itemType);
                                parcel.writeInt(itemId);
                                parcel.writeByte((byte) (followed ? 1 : 0));
                            }
                        }
                    }

                    public static class CoverBean implements Parcelable {


                        private String feed;
                        private String detail;
                        private String blurred;
                        private Object sharing;

                        protected CoverBean(Parcel in) {
                            feed = in.readString();
                            detail = in.readString();
                            blurred = in.readString();
                        }

                        public static final Creator<CoverBean> CREATOR = new Creator<CoverBean>() {
                            @Override
                            public CoverBean createFromParcel(Parcel in) {
                                return new CoverBean(in);
                            }

                            @Override
                            public CoverBean[] newArray(int size) {
                                return new CoverBean[size];
                            }
                        };

                        public String getFeed() {
                            return feed;
                        }

                        public void setFeed(String feed) {
                            this.feed = feed;
                        }

                        public String getDetail() {
                            return detail;
                        }

                        public void setDetail(String detail) {
                            this.detail = detail;
                        }

                        public String getBlurred() {
                            return blurred;
                        }

                        public void setBlurred(String blurred) {
                            this.blurred = blurred;
                        }

                        public Object getSharing() {
                            return sharing;
                        }

                        public void setSharing(Object sharing) {
                            this.sharing = sharing;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i) {
                            parcel.writeString(feed);
                            parcel.writeString(detail);
                            parcel.writeString(blurred);
                        }
                    }

                    public static class WebUrlBean implements Parcelable {
                        /**
                         * raw : http://www.eyepetizer.net/detail.html?vid=11755
                         * forWeibo : http://wandou.im/3inchv
                         */

                        private String raw;
                        private String forWeibo;

                        protected WebUrlBean(Parcel in) {
                            raw = in.readString();
                            forWeibo = in.readString();
                        }

                        public static final Creator<WebUrlBean> CREATOR = new Creator<WebUrlBean>() {
                            @Override
                            public WebUrlBean createFromParcel(Parcel in) {
                                return new WebUrlBean(in);
                            }

                            @Override
                            public WebUrlBean[] newArray(int size) {
                                return new WebUrlBean[size];
                            }
                        };

                        public String getRaw() {
                            return raw;
                        }

                        public void setRaw(String raw) {
                            this.raw = raw;
                        }

                        public String getForWeibo() {
                            return forWeibo;
                        }

                        public void setForWeibo(String forWeibo) {
                            this.forWeibo = forWeibo;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i) {
                            parcel.writeString(raw);
                            parcel.writeString(forWeibo);
                        }
                    }

                    public static class ConsumptionBean implements Parcelable {
                        /**
                         * collectionCount : 37
                         * shareCount : 53
                         * replyCount : 0
                         */

                        private int collectionCount;
                        private int shareCount;
                        private int replyCount;

                        protected ConsumptionBean(Parcel in) {
                            collectionCount = in.readInt();
                            shareCount = in.readInt();
                            replyCount = in.readInt();
                        }

                        public static final Creator<ConsumptionBean> CREATOR = new Creator<ConsumptionBean>() {
                            @Override
                            public ConsumptionBean createFromParcel(Parcel in) {
                                return new ConsumptionBean(in);
                            }

                            @Override
                            public ConsumptionBean[] newArray(int size) {
                                return new ConsumptionBean[size];
                            }
                        };

                        public int getCollectionCount() {
                            return collectionCount;
                        }

                        public void setCollectionCount(int collectionCount) {
                            this.collectionCount = collectionCount;
                        }

                        public int getShareCount() {
                            return shareCount;
                        }

                        public void setShareCount(int shareCount) {
                            this.shareCount = shareCount;
                        }

                        public int getReplyCount() {
                            return replyCount;
                        }

                        public void setReplyCount(int replyCount) {
                            this.replyCount = replyCount;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i) {
                            parcel.writeInt(collectionCount);
                            parcel.writeInt(shareCount);
                            parcel.writeInt(replyCount);
                        }
                    }

                    public static class PlayInfoBean implements Parcelable {
                        /**
                         * height : 270
                         * width : 480
                         * name : 流畅
                         * type : low
                         * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=low
                         */

                        private int height;
                        private int width;
                        private String name;
                        private String type;
                        private String url;

                        protected PlayInfoBean(Parcel in) {
                            height = in.readInt();
                            width = in.readInt();
                            name = in.readString();
                            type = in.readString();
                            url = in.readString();
                        }

                        public static final Creator<PlayInfoBean> CREATOR = new Creator<PlayInfoBean>() {
                            @Override
                            public PlayInfoBean createFromParcel(Parcel in) {
                                return new PlayInfoBean(in);
                            }

                            @Override
                            public PlayInfoBean[] newArray(int size) {
                                return new PlayInfoBean[size];
                            }
                        };

                        public int getHeight() {
                            return height;
                        }

                        public void setHeight(int height) {
                            this.height = height;
                        }

                        public int getWidth() {
                            return width;
                        }

                        public void setWidth(int width) {
                            this.width = width;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel parcel, int i) {
                            parcel.writeInt(height);
                            parcel.writeInt(width);
                            parcel.writeString(name);
                            parcel.writeString(type);
                            parcel.writeString(url);
                        }
                    }
                }
            }
        }
    }
}
