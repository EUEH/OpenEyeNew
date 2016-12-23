package com.eueh.openeye.selection.selection_main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈焕栋 on 16/12/20.
 */

public class SelectionBean {


    private int count;
    private int total;
    private String nextPageUrl;
    private long date;
    private long nextPublishTime;
    private Object dialog;
    private List<ItemListBeanX> itemList;

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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public List<ItemListBeanX> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBeanX {


        private String type;
        private DataBeanX data;

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

        public static class DataBeanX {


            private String dataType;
            private int id;
            private String title;
            private String description;
            private ProviderBean provider;
            private String category;
            private Object author;
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
            private String text ;
            private String image ;
            private HeaderBean header ;

    //
            public HeaderBean getHeader() {
        return header;
    }

            public DataBeanX setHeader(HeaderBean header) {
                this.header = header;
                return this;
            }

            public static class HeaderBean {
                private int id ;
                private String title ;
                private String font ;
                private String cover ;
                private String actionUrl ;
                private String description ;




                public String getDescription() {
                    return description;
                }

                public HeaderBean setDescription(String description) {
                    this.description = description;
                    return this;
                }

                private List<String> iconList;

                public List<String> getIconList() {
                    return iconList;
                }

                public void setIconList(List<String> iconList) {
                    this.iconList = iconList;
                }

                public int getId() {
                    return id;
                }

                public HeaderBean setId(int id) {
                    this.id = id;
                    return this;
                }

                public String getTitle() {
                    return title;
                }

                public HeaderBean setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public String getFont() {
                    return font;
                }

                public HeaderBean setFont(String font) {
                    this.font = font;
                    return this;
                }

                public String getCover() {
                    return cover;
                }

                public HeaderBean setCover(String cover) {
                    this.cover = cover;
                    return this;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public HeaderBean setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                    return this;
                }
            }
    //



            private List<ItemListBean> itemList;

            public static class ItemListBean {
                private String type ;
                private DataBeanXX data ;
                public static class DataBeanXX {
                    //最里层data
/////////////////////////////
                    private CoverBeanXX cover ;
                    private String title ;
                    private String category ;
                    private String releaseTime ;
                    private String text ;


                    public String getText() {
                        return text;
                    }

                    public DataBeanXX setText(String text) {
                        this.text = text;
                        return this;
                    }

                    public String getReleaseTime() {
                        return releaseTime;
                    }

                    public DataBeanXX setReleaseTime(String releaseTime) {
                        this.releaseTime = releaseTime;
                        return this;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public DataBeanXX setCategory(String category) {
                        this.category = category;
                        return this;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public DataBeanXX setTitle(String title) {
                        this.title = title;
                        return this;
                    }
//////////////////////////////////
                    public static class CoverBeanXX {
                        //里面是不同清晰度图片
                        private String feed ;

                        public String getFeed() {
                            return feed;
                        }

                        public CoverBeanXX setFeed(String feed) {
                            this.feed = feed;
                            return this;
                        }
                    }

                    public CoverBeanXX getCover() {
                        return cover;
                    }

                    public DataBeanXX setCover(CoverBeanXX cover) {
                        this.cover = cover;
                        return this;
                    }
                }

                public String getType() {
                    return type;
                }

                public ItemListBean setType(String type) {
                    this.type = type;
                    return this;
                }

                public DataBeanXX getData() {
                    return data;
                }

                public ItemListBean setData(DataBeanXX data) {
                    this.data = data;
                    return this;
                }
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public DataBeanX setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
                return this;
            }




            public String getImage() {
                return image;
            }

            public DataBeanX setImage(String image) {
                this.image = image;
                return this;
            }

            public String getText() {
                return text;
            }

            public DataBeanX setText(String text) {
                this.text = text;
                return this;
            }

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

            public Object getAuthor() {
                return author;
            }

            public void setAuthor(Object author) {
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

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class ProviderBean {


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
