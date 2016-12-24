package com.eueh.openeye.concern;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/20.
 */

public class ConcernBean {



    private int count;
    private int total;
    private String nextPageUrl;
    private Object updateTime;
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

    public static class ItemListBeanX {
        /**
         * type : videoCollectionWithBrief
         * data : {"dataType":"ItemCollection","header":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","iconType":"round","title":"一条视频","subTitle":null,"description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","actionUrl":"eyepetizer://pgc/detail/170/?title=%E4%B8%80%E6%9D%A1%E8%A7%86%E9%A2%91","adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"itemList":[{"type":"video","data":{"dataType":"VideoBeanForClient","id":11755,"title":"如何过一个有仪式感的圣诞节","description":"圣诞节就要到了，美女甜点师Snow教你用空气凤梨和小甜点，布置一个温馨甜蜜的节日餐桌。操作简单，所有道具都可以在花鸟市场和网上买到，现在赶紧准备起来，今年在家就能过一个有仪式感的圣诞节！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"生活","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","blurred":"","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=default","duration":153,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11755","forWeibo":"http://wandou.im/3inchv"},"releaseTime":1482129350000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=high"}],"consumption":{"collectionCount":37,"shareCount":53,"replyCount":0},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482129350000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11707,"title":"张艺谋的「长城」，是惊喜还是惊吓？","description":"「美国英雄为什么一定要跟中国女人滚床单，中国的女将军你能追到手？不可能！」「饕餮跟哥斯拉打，谁赢？我认为饕餮赢。」谈起新片「长城」，导演张艺谋的吐槽功力也是飙升到极点，段子频出，全程高能！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"记录","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/ab8f2b3dd1747b31fe2afc359318c6a2.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/ab8f2b3dd1747b31fe2afc359318c6a2.jpeg?imageMogr2/quality/60","blurred":"1","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=default","duration":459,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11707","forWeibo":"http://wandou.im/3i366l"},"releaseTime":1481866724000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=high"}],"consumption":{"collectionCount":2377,"shareCount":5829,"replyCount":132},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":598,"name":"访谈","actionUrl":"eyepetizer://tag/598/?title=%E8%AE%BF%E8%B0%88","adTrack":null},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null},{"id":570,"name":"电影相关","actionUrl":"eyepetizer://tag/570/?title=%E7%94%B5%E5%BD%B1%E7%9B%B8%E5%85%B3","adTrack":null},{"id":656,"name":"幕后","actionUrl":"eyepetizer://tag/656/?title=%E5%B9%95%E5%90%8E","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481866724000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11695,"title":"孤独图书馆后，他又改造了家美术馆","description":"董功，是一名建筑师，曾刷爆互联网的\u201c全中国最孤独的图书馆\u201d就是他的作品。去年，他接受了一项挑战：在42天内改建2000平米的木木美术馆。时间紧迫，董功还是接受了这项挑战！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"记录","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/8f86e2c83bef54057c703ecf28b6c399.png","detail":"http://img.kaiyanapp.com/8f86e2c83bef54057c703ecf28b6c399.png","blurred":"http://img.kaiyanapp.com/7f91edaf6ddf27c9d312fa1bdd69ff79.png","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=default","duration":234,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11695","forWeibo":"http://wandou.im/3hxmlh"},"releaseTime":1481793417000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=high"}],"consumption":{"collectionCount":235,"shareCount":120,"replyCount":1},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481793417000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11626,"title":"特条丨一生需要住一次荒野酒店","description":"原始荒野、滚滚黄沙，野生动物在帐篷外探头探脑\u2026\u2026这里不是西部片的片场，而是澳大利亚南部的康阿路纳帐篷营地。14 年前，营地主人 Geoff 在此开了个只有 4 顶帐篷的酒店，远离城市，但这里的银河亮得不可思议。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"旅行","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/0c22882788a4044dca12323fc93e6271.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/0c22882788a4044dca12323fc93e6271.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/9bf74b9bf73aeb21d97e67611d8e09f5.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=default","duration":283,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11626","forWeibo":"http://wandou.im/3hol72"},"releaseTime":1481685220000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=high"}],"consumption":{"collectionCount":1478,"shareCount":1506,"replyCount":21},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":548,"name":"星空","actionUrl":"eyepetizer://tag/548/?title=%E6%98%9F%E7%A9%BA","adTrack":null},{"id":10,"name":"旅行","actionUrl":"eyepetizer://tag/10/?title=%E6%97%85%E8%A1%8C","adTrack":null},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481685220000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11610,"title":"这位老炮儿，是京城潮人心目中最牛的！","description":"北京人郭宇因喜欢电影《霹雳舞》里演员穿的球鞋，从此和鞋结下不解之缘，30多年收集了1000多双限量球鞋，包括几乎全套的Jordan系列签名球鞋，他开的东四北大街\u201c亚新\u201d鞋店，更成为时髦青年的潮流地标。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"记录","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/c50d2ce98ac113578b843d814472f7e4.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/c50d2ce98ac113578b843d814472f7e4.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/676f4b8c1be182764072e04bdf8c1ac4.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=default","duration":278,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11610","forWeibo":"http://wandou.im/3hkb2u"},"releaseTime":1481625200000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=high"}],"consumption":{"collectionCount":312,"shareCount":689,"replyCount":9},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481625200000,"promotion":null,"label":null,"collected":false,"played":false}}],"count":5,"adTrack":null}
         */

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
            /**
             * dataType : ItemCollection
             * header : {"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","iconType":"round","title":"一条视频","subTitle":null,"description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","actionUrl":"eyepetizer://pgc/detail/170/?title=%E4%B8%80%E6%9D%A1%E8%A7%86%E9%A2%91","adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}}
             * itemList : [{"type":"video","data":{"dataType":"VideoBeanForClient","id":11755,"title":"如何过一个有仪式感的圣诞节","description":"圣诞节就要到了，美女甜点师Snow教你用空气凤梨和小甜点，布置一个温馨甜蜜的节日餐桌。操作简单，所有道具都可以在花鸟市场和网上买到，现在赶紧准备起来，今年在家就能过一个有仪式感的圣诞节！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"生活","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","blurred":"","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=default","duration":153,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11755","forWeibo":"http://wandou.im/3inchv"},"releaseTime":1482129350000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=high"}],"consumption":{"collectionCount":37,"shareCount":53,"replyCount":0},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482129350000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11707,"title":"张艺谋的「长城」，是惊喜还是惊吓？","description":"「美国英雄为什么一定要跟中国女人滚床单，中国的女将军你能追到手？不可能！」「饕餮跟哥斯拉打，谁赢？我认为饕餮赢。」谈起新片「长城」，导演张艺谋的吐槽功力也是飙升到极点，段子频出，全程高能！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"记录","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/ab8f2b3dd1747b31fe2afc359318c6a2.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/ab8f2b3dd1747b31fe2afc359318c6a2.jpeg?imageMogr2/quality/60","blurred":"1","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=default","duration":459,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11707","forWeibo":"http://wandou.im/3i366l"},"releaseTime":1481866724000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11707&editionType=high"}],"consumption":{"collectionCount":2377,"shareCount":5829,"replyCount":132},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":598,"name":"访谈","actionUrl":"eyepetizer://tag/598/?title=%E8%AE%BF%E8%B0%88","adTrack":null},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null},{"id":570,"name":"电影相关","actionUrl":"eyepetizer://tag/570/?title=%E7%94%B5%E5%BD%B1%E7%9B%B8%E5%85%B3","adTrack":null},{"id":656,"name":"幕后","actionUrl":"eyepetizer://tag/656/?title=%E5%B9%95%E5%90%8E","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481866724000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11695,"title":"孤独图书馆后，他又改造了家美术馆","description":"董功，是一名建筑师，曾刷爆互联网的\u201c全中国最孤独的图书馆\u201d就是他的作品。去年，他接受了一项挑战：在42天内改建2000平米的木木美术馆。时间紧迫，董功还是接受了这项挑战！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"记录","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/8f86e2c83bef54057c703ecf28b6c399.png","detail":"http://img.kaiyanapp.com/8f86e2c83bef54057c703ecf28b6c399.png","blurred":"http://img.kaiyanapp.com/7f91edaf6ddf27c9d312fa1bdd69ff79.png","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=default","duration":234,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11695","forWeibo":"http://wandou.im/3hxmlh"},"releaseTime":1481793417000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11695&editionType=high"}],"consumption":{"collectionCount":235,"shareCount":120,"replyCount":1},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481793417000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11626,"title":"特条丨一生需要住一次荒野酒店","description":"原始荒野、滚滚黄沙，野生动物在帐篷外探头探脑\u2026\u2026这里不是西部片的片场，而是澳大利亚南部的康阿路纳帐篷营地。14 年前，营地主人 Geoff 在此开了个只有 4 顶帐篷的酒店，远离城市，但这里的银河亮得不可思议。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"旅行","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/0c22882788a4044dca12323fc93e6271.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/0c22882788a4044dca12323fc93e6271.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/9bf74b9bf73aeb21d97e67611d8e09f5.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=default","duration":283,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11626","forWeibo":"http://wandou.im/3hol72"},"releaseTime":1481685220000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11626&editionType=high"}],"consumption":{"collectionCount":1478,"shareCount":1506,"replyCount":21},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":548,"name":"星空","actionUrl":"eyepetizer://tag/548/?title=%E6%98%9F%E7%A9%BA","adTrack":null},{"id":10,"name":"旅行","actionUrl":"eyepetizer://tag/10/?title=%E6%97%85%E8%A1%8C","adTrack":null},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481685220000,"promotion":null,"label":null,"collected":false,"played":false}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":11610,"title":"这位老炮儿，是京城潮人心目中最牛的！","description":"北京人郭宇因喜欢电影《霹雳舞》里演员穿的球鞋，从此和鞋结下不解之缘，30多年收集了1000多双限量球鞋，包括几乎全套的Jordan系列签名球鞋，他开的东四北大街\u201c亚新\u201d鞋店，更成为时髦青年的潮流地标。","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"记录","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/c50d2ce98ac113578b843d814472f7e4.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/c50d2ce98ac113578b843d814472f7e4.jpeg?imageMogr2/quality/60","blurred":"http://img.kaiyanapp.com/676f4b8c1be182764072e04bdf8c1ac4.jpeg?imageMogr2/quality/60","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=default","duration":278,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11610","forWeibo":"http://wandou.im/3hkb2u"},"releaseTime":1481625200000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11610&editionType=high"}],"consumption":{"collectionCount":312,"shareCount":689,"replyCount":9},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1481625200000,"promotion":null,"label":null,"collected":false,"played":false}}]
             * count : 5
             * adTrack : null
             */

            private String dataType;
            private HeaderBean header;
            private int count;
            private Object adTrack;
            private List<ItemListBean> itemList;

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

            public static class HeaderBean {
                /**
                 * id : 170
                 * icon : http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg
                 * iconType : round
                 * title : 一条视频
                 * subTitle : null
                 * description : 每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺
                 * actionUrl : eyepetizer://pgc/detail/170/?title=%E4%B8%80%E6%9D%A1%E8%A7%86%E9%A2%91
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":170,"followed":false}
                 */

                private int id;
                private String icon;
                private String iconType;
                private String title;
                private Object subTitle;
                private String description;
                private String actionUrl;
                private Object adTrack;
                private FollowBean follow;

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

                public static class FollowBean {
                    /**
                     * itemType : author
                     * itemId : 170
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

            public static class ItemListBean {
                /**
                 * type : video
                 * data : {"dataType":"VideoBeanForClient","id":11755,"title":"如何过一个有仪式感的圣诞节","description":"圣诞节就要到了，美女甜点师Snow教你用空气凤梨和小甜点，布置一个温馨甜蜜的节日餐桌。操作简单，所有道具都可以在花鸟市场和网上买到，现在赶紧准备起来，今年在家就能过一个有仪式感的圣诞节！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"生活","author":{"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","blurred":"","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=default","duration":153,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=11755","forWeibo":"http://wandou.im/3inchv"},"releaseTime":1482129350000,"playInfo":[{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=high"}],"consumption":{"collectionCount":37,"shareCount":53,"replyCount":0},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1482129350000,"promotion":null,"label":null,"collected":false,"played":false}
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
                     * dataType : VideoBeanForClient
                     * id : 11755
                     * title : 如何过一个有仪式感的圣诞节
                     * description : 圣诞节就要到了，美女甜点师Snow教你用空气凤梨和小甜点，布置一个温馨甜蜜的节日餐桌。操作简单，所有道具都可以在花鸟市场和网上买到，现在赶紧准备起来，今年在家就能过一个有仪式感的圣诞节！
                     * provider : {"name":"PGC","alias":"PGC","icon":""}
                     * category : 生活
                     * author : {"id":170,"icon":"http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg","name":"一条视频","description":"每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺","link":"","latestReleaseTime":1482129350000,"videoNum":85,"adTrack":null,"follow":{"itemType":"author","itemId":170,"followed":false}}
                     * cover : {"feed":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","detail":"http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60","blurred":"","sharing":null}
                     * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=default
                     * duration : 153
                     * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=11755","forWeibo":"http://wandou.im/3inchv"}
                     * releaseTime : 1482129350000
                     * playInfo : [{"height":270,"width":480,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=high"}]
                     * consumption : {"collectionCount":37,"shareCount":53,"replyCount":0}
                     * campaign : null
                     * waterMarks : null
                     * adTrack : null
                     * tags : []
                     * type : NORMAL
                     * idx : 0
                     * shareAdTrack : null
                     * favoriteAdTrack : null
                     * webAdTrack : null
                     * date : 1482129350000
                     * promotion : null
                     * label : null
                     * collected : false
                     * played : false
                     */

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

                    public static class ProviderBean {
                        /**
                         * name : PGC
                         * alias : PGC
                         * icon :
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

                    public static class AuthorBean {
                        /**
                         * id : 170
                         * icon : http://img.kaiyanapp.com/d4164990b1328ce8ce41bfab7085f9e1.jpeg
                         * name : 一条视频
                         * description : 每天一条3分钟原创视频，精选人间美物。生活丨潮流丨文艺
                         * link :
                         * latestReleaseTime : 1482129350000
                         * videoNum : 85
                         * adTrack : null
                         * follow : {"itemType":"author","itemId":170,"followed":false}
                         */

                        private int id;
                        private String icon;
                        private String name;
                        private String description;
                        private String link;
                        private long latestReleaseTime;
                        private int videoNum;
                        private Object adTrack;
                        private FollowBeanX follow;

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

                        public static class FollowBeanX {
                            /**
                             * itemType : author
                             * itemId : 170
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

                    public static class CoverBean {
                        /**
                         * feed : http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60
                         * detail : http://img.kaiyanapp.com/494bacbee1efe5d547ec126af0fa6a18.jpeg?imageMogr2/quality/60
                         * blurred :
                         * sharing : null
                         */

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
                         * raw : http://www.eyepetizer.net/detail.html?vid=11755
                         * forWeibo : http://wandou.im/3inchv
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
                         * collectionCount : 37
                         * shareCount : 53
                         * replyCount : 0
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
                         * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=11755&editionType=low
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
                }
            }
        }
    }
}
