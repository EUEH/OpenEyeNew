package com.eueh.openeye.selection.selection_detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class SelectionDetailBean {



    private String nextPageUrl;
    private long nextPublishTime;
    private String newestIssueType;
    private Object dialog;
    private List<IssueListBean> issueList;

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public String getNewestIssueType() {
        return newestIssueType;
    }

    public void setNewestIssueType(String newestIssueType) {
        this.newestIssueType = newestIssueType;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public List<IssueListBean> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<IssueListBean> issueList) {
        this.issueList = issueList;
    }

    public static class IssueListBean {


        private long releaseTime;
        private String type;
        private long date;
        private long publishTime;
        private int count;
        private List<ItemListBean> itemList;

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListBean {


            private String type;
            private DataBean data;

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

            public static class DataBean {


                private String dataType;
                private int id;
                private String title;
                private String description;
                private ProviderBean provider;
                private String category;
                ///////////////


                ///////////////
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
                private List<TagsBean> tags;
                /**
                 * author : {"id":258,"icon":"http://img.kaiyanapp.com/7db61f0abaffb56c148d824044c96265.jpeg?imageMogr2/quality/60","name":"迷迭香","description":"周一到周五每天一条美食精品原创视频，2 分钟学做菜，一起体会生活的美好。","link":"","latestReleaseTime":1482377276000,"videoNum":35,"adTrack":null,"follow":{"itemType":"author","itemId":258,"followed":false}}
                 */

                @SerializedName("author")
                private AuthorBean authorX;

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

                public List<TagsBean> getTags() {
                    return tags;
                }

                public void setTags(List<TagsBean> tags) {
                    this.tags = tags;
                }

                public AuthorBean getAuthorX() {
                    return authorX;
                }

                public void setAuthorX(AuthorBean authorX) {
                    this.authorX = authorX;
                }
                public static class AuthorBean {
                    /**
                     * id : 258
                     * icon : http://img.kaiyanapp.com/7db61f0abaffb56c148d824044c96265.jpeg?imageMogr2/quality/60
                     * name : 迷迭香
                     * description : 周一到周五每天一条美食精品原创视频，2 分钟学做菜，一起体会生活的美好。
                     * link :
                     * latestReleaseTime : 1482377276000
                     * videoNum : 35
                     * adTrack : null
                     * follow : {"itemType":"author","itemId":258,"followed":false}
                     */

                    @SerializedName("id")
                    private int idX;
                    private String icon;
                    private String name;
                    @SerializedName("description")
                    private String descriptionX;
                    private String link;
                    private long latestReleaseTime;
                    private int videoNum;
                    @SerializedName("adTrack")
                    private Object adTrackX;
                    private FollowBean follow;

                    public int getIdX() {
                        return idX;
                    }

                    public void setIdX(int idX) {
                        this.idX = idX;
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

                    public String getDescriptionX() {
                        return descriptionX;
                    }

                    public void setDescriptionX(String descriptionX) {
                        this.descriptionX = descriptionX;
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

                    public Object getAdTrackX() {
                        return adTrackX;
                    }

                    public void setAdTrackX(Object adTrackX) {
                        this.adTrackX = adTrackX;
                    }

                    public FollowBean getFollow() {
                        return follow;
                    }

                    public void setFollow(FollowBean follow) {
                        this.follow = follow;
                    }

                    public static class FollowBean {
                        /**
                         * itemType : author
                         * itemId : 258
                         * followed : false
                         */

                        private String itemType;
                        private int itemId;
                        private boolean followed;

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
                    }
                }
                public static class ProviderBean {
                    /**
                     * name : YouTube
                     * alias : youtube
                     * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
                     */

                    private String name;
                    private String alias;
                    private String icon;

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
                }

                public static class CoverBean {


                    private String feed;
                    private String detail;
                    private String blurred;
                    private Object sharing;

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
                }

                public static class WebUrlBean {
                    /**
                     * raw : http://www.eyepetizer.net/detail.html?vid=11168
                     * forWeibo : http://wandou.im/3dxm9i
                     */

                    private String raw;
                    private String forWeibo;

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
                }

                public static class ConsumptionBean {
                    /**
                     * collectionCount : 32
                     * shareCount : 146
                     * replyCount : 4
                     */

                    private int collectionCount;
                    private int shareCount;
                    private int replyCount;

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
                }

                public static class PlayInfoBean {
                    /**
                     * height : 270
                     * width : 480
                     * name : 流畅
                     * type : low
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11168&editionType=low
                     */

                    private int height;
                    private int width;
                    private String name;
                    private String type;
                    private String url;

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
                }

                public static class TagsBean {
                    /**
                     * id : 16
                     * name : 广告
                     * actionUrl : eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A
                     * adTrack : null
                     */

                    private int id;
                    private String name;
                    private String actionUrl;
                    private Object adTrack;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
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
                }


            }
        }
    }
}
