package com.eueh.openeye.concern.author;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/28.
 */

public class ConcernAuthorBean {

    private int count;
    private int total;
    private String nextPageUrl;
    private List<ItemListBean> itemList;

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

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * type : leftAlignTextHeader
         * data : {"dataType":"LeftAlignTextHeader","text":"热门作者","font":"normal","actionUrl":null,"adTrack":null}
         */

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
            /**
             * dataType : LeftAlignTextHeader
             * text : 热门作者
             * font : normal
             * actionUrl : null
             * adTrack : null
             */

            private String dataType;
            private String text;
            private String font;
            private Object actionUrl;
            private Object adTrack;
            private String title;
            private String icon;
            private String description;

            private HeaderBeanX header ;

            public HeaderBeanX getHeader() {
                return header;
            }

            public DataBean setHeader(HeaderBeanX header) {
                this.header = header;
                return this;
            }

            public static  class HeaderBeanX {
                private String title;
                private String icon;
                private String description;

                public String getTitle() {
                    return title;
                }

                public HeaderBeanX setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public String getIcon() {
                    return icon;
                }

                public HeaderBeanX setIcon(String icon) {
                    this.icon = icon;
                    return this;
                }

                public String getDescription() {
                    return description;
                }

                public HeaderBeanX setDescription(String description) {
                    this.description = description;
                    return this;
                }
            }



            public String getTitle() {
                return title;
            }

            public DataBean setTitle(String title) {
                this.title = title;
                return this;
            }

            public String getIcon() {
                return icon;
            }

            public DataBean setIcon(String icon) {
                this.icon = icon;
                return this;
            }

            public String getDescription() {
                return description;
            }

            public DataBean setDescription(String description) {
                this.description = description;
                return this;
            }

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getFont() {
                return font;
            }

            public void setFont(String font) {
                this.font = font;
            }

            public Object getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(Object actionUrl) {
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
