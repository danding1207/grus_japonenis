package com.msc.lib.net.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by msc on 2016/3/29.
 */
public class Destinations implements Parcelable {

    /**
     * message : ok
     * status : 200
     * data : [{"name":"大陆热门目的地","region":"china","destinations":[{"id":109,"district_id":100007,"parent_id":5,"name":"云南","name_en":"Yunnan","name_pinyin":"yun nan|yn","score":1165,"level":3,"path":".1.5.109.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/109/2b85ab3d7ebda3c321436a6147153f09.jpg","lat":25.0454,"lng":102.71},{"id":166,"district_id":100009,"parent_id":5,"name":"四川","name_en":"Sichuan","name_pinyin":"si chuan|sc","score":1160,"level":3,"path":".1.5.166.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/166/8af7b5a816fa0715b446bab2fd8b6be9.jpg","lat":30.6517,"lng":104.076},{"id":380,"district_id":61,"parent_id":5,"name":"三亚","name_en":"Sanya","name_pinyin":"san ya|sy","score":1159,"level":3,"path":".1.5.380.","published":true,"is_in_china":true,"inspiration_activities_count":70,"activity_collections_count":12,"wishes_count":12342,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/380/7340e257abafb560d16e08d340dcdcfc.jpg","lat":18.2528,"lng":109.512},{"id":91,"district_id":2,"parent_id":5,"name":"上海","name_en":"Shanghai","name_pinyin":"shang hai|sh","score":200,"level":3,"path":".1.5.91.","published":true,"is_in_china":true,"inspiration_activities_count":122,"activity_collections_count":16,"wishes_count":50894,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/91/d36b1ee5718998563cb1e52d185adebe.jpg","lat":31.2305,"lng":121.474},{"id":93,"district_id":1,"parent_id":5,"name":"北京","name_en":"Beijing","name_pinyin":"bei jing|bj","score":190,"level":3,"path":".1.5.93.","published":true,"is_in_china":true,"inspiration_activities_count":108,"activity_collections_count":13,"wishes_count":35282,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/93/30cba7db5b7e19beefa9b128a5f54606.jpg","lat":39.9042,"lng":116.407},{"id":90,"district_id":21,"parent_id":5,"name":"厦门","name_en":"Xiamen","name_pinyin":"sha men|sm","score":180,"level":3,"path":".1.5.90.","published":true,"is_in_china":true,"inspiration_activities_count":75,"activity_collections_count":11,"wishes_count":49808,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/90/cadbb5cb0d246026978a41c8a6c18895.jpg","lat":24.4865,"lng":118.089},{"id":437,"district_id":100051,"parent_id":5,"name":"广东","name_en":"Guangdong","name_pinyin":"guang dong|gd","score":150,"level":3,"path":".1.5.437.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/437/5b4ffe996346e3b7780e7e87e949a31d.jpg","lat":23.1322,"lng":113.267},{"id":416,"district_id":100065,"parent_id":5,"name":"浙江","name_en":"Zhejiang","name_pinyin":"zhe jiang|zj","score":130,"level":3,"path":".1.5.416.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/416/a77b87fe2a72e0897bdc8b4126065393.jpg","lat":30.2663,"lng":120.154},{"id":414,"district_id":100066,"parent_id":5,"name":"江苏","name_en":"Jiangsu","name_pinyin":"jiang su|js","score":120,"level":3,"path":".1.5.414.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":18,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/414/9d24fbebf508f02c6d54e6a7208543d4.jpg","lat":32.0617,"lng":118.763}]},{"name":"台港澳","region":"hk","destinations":[{"id":34,"district_id":100076,"parent_id":5,"name":"台湾","name_en":"Taiwan","name_pinyin":"tai wan|tw","score":1170,"level":3,"path":".1.5.34.","published":true,"is_in_china":true,"inspiration_activities_count":47,"activity_collections_count":7,"wishes_count":23454,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/34/a3d0a04f8eed43b06948edcc19ee492b.jpg","lat":23.6978,"lng":120.961},{"id":48,"district_id":38,"parent_id":5,"name":"香港","name_en":"Hong Kong","name_pinyin":"xiang gang|xg","score":0,"level":3,"path":".1.5.48.","published":true,"is_in_china":true,"inspiration_activities_count":84,"activity_collections_count":12,"wishes_count":30413,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/48/b774f77f6327da4d55903a9d7b538734.jpg","lat":22.3964,"lng":114.109},{"id":49,"district_id":39,"parent_id":5,"name":"澳门","name_en":"Macau","name_pinyin":"ao men|am","score":0,"level":3,"path":".1.5.49.","published":true,"is_in_china":true,"inspiration_activities_count":64,"activity_collections_count":9,"wishes_count":11665,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/49/5bd98c353fcb985490a682e51f759704.jpg","lat":22.1638,"lng":113.555}]},{"name":"亚洲热门目的地","region":"asia","destinations":[{"id":31,"district_id":100041,"parent_id":1,"name":"日本","name_en":"Japan","name_pinyin":"ri ben|rb","score":1200,"level":2,"path":".1.31.","published":true,"is_in_china":false,"inspiration_activities_count":39,"activity_collections_count":5,"wishes_count":8656,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/31/5fd731b5202f001e306f51f3817c2870.jpg","lat":36.2048,"lng":138.253},{"id":39,"district_id":100042,"parent_id":1,"name":"韩国","name_en":"South Korea","name_pinyin":"han guo|hg","score":1190,"level":2,"path":".1.39.","published":true,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/39/7a09ae1e7fbbb68223e53f9804929017.jpg","lat":35.9078,"lng":127.767},{"id":8,"district_id":100021,"parent_id":1,"name":"泰国","name_en":"Thailand","name_pinyin":"tai guo|tg","score":1175,"level":2,"path":".1.8.","published":true,"is_in_china":false,"inspiration_activities_count":62,"activity_collections_count":8,"wishes_count":18749,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/8/152afc5f6b1d599a7d3f954d3eabd464.jpg","lat":15.87,"lng":100.993},{"id":69,"district_id":100022,"parent_id":1,"name":"马来西亚","name_en":"Malaysia","name_pinyin":"ma lai xi ya|mlxy","score":160,"level":2,"path":".1.69.","published":true,"is_in_china":false,"inspiration_activities_count":54,"activity_collections_count":8,"wishes_count":4248,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/69/ac3a16cf2a488a5cde4e1ef7fc6aa945.jpg","lat":4.21048,"lng":101.976},{"id":33,"district_id":53,"parent_id":1,"name":"新加坡","name_en":"Singapore","name_pinyin":"xin jia po|xjp","score":150,"level":2,"path":".1.33.","published":true,"is_in_china":false,"inspiration_activities_count":73,"activity_collections_count":11,"wishes_count":16105,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/33/51ed75fd952d01897ca086b59f040a2a.jpg","lat":1.35208,"lng":103.82},{"id":88,"district_id":1445561,"parent_id":1,"name":"马尔代夫","name_en":"Maldives","name_pinyin":"ma er dai fu|medf","score":140,"level":2,"path":".1.88.","published":true,"is_in_china":false,"inspiration_activities_count":88,"activity_collections_count":9,"wishes_count":5211,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/88/831a566a741b392eeb0095890b4abd86.jpg","lat":3.20278,"lng":73.2207},{"id":57,"district_id":100045,"parent_id":1,"name":"印度尼西亚","name_en":"Indonesia","name_pinyin":"yin du ni xi ya|ydnxy","score":130,"level":2,"path":".1.57.","published":true,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/57/98fa9b4cce2c92cfff4b56ef3ebc3d13.jpg","lat":-0.789275,"lng":113.921},{"id":75,"district_id":100046,"parent_id":1,"name":"越南","name_en":"Vietnam","name_pinyin":"yue nan|yn","score":122,"level":2,"path":".1.75.","published":true,"is_in_china":false,"inspiration_activities_count":55,"activity_collections_count":8,"wishes_count":6695,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/75/a77db7b8a78b0e06e30b5ec74a6c4a18.jpg","lat":14.0583,"lng":108.277},{"id":42,"district_id":100079,"parent_id":1,"name":"尼泊尔","name_en":"Nepal","name_pinyin":"ni bo er|nbe","score":121,"level":2,"path":".1.42.","published":true,"is_in_china":false,"inspiration_activities_count":47,"activity_collections_count":8,"wishes_count":2684,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/42/e22e818f7634b4867b49aac4ce4aa190.jpg","lat":28.3949,"lng":84.124}]},{"name":"欧洲热门目的地","region":"europe","destinations":[{"id":138,"district_id":100024,"parent_id":2,"name":"法国","name_en":"France","name_pinyin":"fa guo|fg","score":1140,"level":2,"path":".2.138.","published":false,"is_in_china":false,"inspiration_activities_count":97,"activity_collections_count":10,"wishes_count":9559,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/138/3cbee6fbeb49aca75f903c4136c08c91.jpg","lat":46.2276,"lng":2.21375},{"id":141,"district_id":100035,"parent_id":2,"name":"西班牙","name_en":"Spain","name_pinyin":"xi ban ya|xby","score":1135,"level":2,"path":".2.141.","published":false,"is_in_china":false,"inspiration_activities_count":71,"activity_collections_count":7,"wishes_count":4951,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/141/8fcb0ab57b71e04dd68bb0291d8a6f05.jpg","lat":40.4637,"lng":-3.74922},{"id":115,"district_id":100026,"parent_id":2,"name":"意大利","name_en":"Italy","name_pinyin":"yi da li|ydl","score":1130,"level":2,"path":".2.115.","published":false,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/115/d5ecdde9c77945c6a00c29928fd51676.jpg","lat":41.8719,"lng":12.5674},{"id":161,"district_id":20354,"parent_id":2,"name":"英国","name_en":"United Kingdom","name_pinyin":"ying guo|yg","score":1125,"level":2,"path":".2.161.","published":false,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/161/8f088a781f9b763641cb3662fd9848cd.jpg","lat":51.5342,"lng":-0.120038},{"id":129,"district_id":100025,"parent_id":2,"name":"德国","name_en":"Germany","name_pinyin":"de guo|dg","score":1120,"level":2,"path":".2.129.","published":false,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/129/4a753ffcb7059d5def9304b25d3e128d.jpg","lat":51.1657,"lng":10.4515},{"id":133,"district_id":100050,"parent_id":2,"name":"瑞士","name_en":"Switzerland","name_pinyin":"rui shi|rs","score":1115,"level":2,"path":".2.133.","published":true,"is_in_china":false,"inspiration_activities_count":78,"activity_collections_count":11,"wishes_count":4415,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/133/347277db2a22a72d3c458747e114df70.jpg","lat":46.8182,"lng":8.22751}]},{"name":"其他热门目的地","region":"other","destinations":[{"id":160,"district_id":100047,"parent_id":7,"name":"美国","name_en":"United States","name_pinyin":"mei guo|mg","score":999,"level":2,"path":".7.160.","published":false,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/160/b8e30573e55e38202a84b3e0b9a595bc.jpg","lat":37.0902,"lng":-95.7129},{"id":143,"district_id":100078,"parent_id":4,"name":"新西兰","name_en":"New Zealand","name_pinyin":"xin xi lan|xxl","score":835,"level":2,"path":".4.143.","published":false,"is_in_china":false,"inspiration_activities_count":61,"activity_collections_count":7,"wishes_count":6974,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/143/22f8215a35c49e917f7cccd0f962ca2b.jpg","lat":-40.9006,"lng":174.886},{"id":288,"district_id":100048,"parent_id":4,"name":"澳大利亚","name_en":"Australia","name_pinyin":"ao da li ya|adly","score":600,"level":2,"path":".4.288.","published":true,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/288/f590f28c11e0f160dfc7de9d57c0360f.jpg","lat":-25.2744,"lng":133.775},{"id":270,"district_id":100108,"parent_id":7,"name":"墨西哥","name_en":"Mexico","name_pinyin":"mo xi ge|mxg","score":500,"level":2,"path":".7.270.","published":true,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/270/c754b1e25f563ef18ebafb4ee9aad81a.jpg","lat":23.6345,"lng":-102.553},{"id":327,"district_id":120487,"parent_id":418,"name":"南极","name_en":"Antarctica","name_pinyin":"nan ji|nj","score":300,"level":2,"path":".418.327.","published":true,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/327/754c4f4b67abc020c8a618ee78b93655.jpg","lat":-79.7652,"lng":29.1204},{"id":303,"district_id":100087,"parent_id":3,"name":"肯尼亚","name_en":"Kenya","name_pinyin":"ken ni ya|kny","score":200,"level":2,"path":".3.303.","published":true,"is_in_china":false,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/303/010e937fd0a1a628e7bb4512fde79aff.jpg","lat":-0.023559,"lng":37.9062}]}]
     */

    private String message;
    private int status;
    /**
     * name : 大陆热门目的地
     * region : china
     * destinations : [{"id":109,"district_id":100007,"parent_id":5,"name":"云南","name_en":"Yunnan","name_pinyin":"yun nan|yn","score":1165,"level":3,"path":".1.5.109.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/109/2b85ab3d7ebda3c321436a6147153f09.jpg","lat":25.0454,"lng":102.71},{"id":166,"district_id":100009,"parent_id":5,"name":"四川","name_en":"Sichuan","name_pinyin":"si chuan|sc","score":1160,"level":3,"path":".1.5.166.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/166/8af7b5a816fa0715b446bab2fd8b6be9.jpg","lat":30.6517,"lng":104.076},{"id":380,"district_id":61,"parent_id":5,"name":"三亚","name_en":"Sanya","name_pinyin":"san ya|sy","score":1159,"level":3,"path":".1.5.380.","published":true,"is_in_china":true,"inspiration_activities_count":70,"activity_collections_count":12,"wishes_count":12342,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/380/7340e257abafb560d16e08d340dcdcfc.jpg","lat":18.2528,"lng":109.512},{"id":91,"district_id":2,"parent_id":5,"name":"上海","name_en":"Shanghai","name_pinyin":"shang hai|sh","score":200,"level":3,"path":".1.5.91.","published":true,"is_in_china":true,"inspiration_activities_count":122,"activity_collections_count":16,"wishes_count":50894,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/91/d36b1ee5718998563cb1e52d185adebe.jpg","lat":31.2305,"lng":121.474},{"id":93,"district_id":1,"parent_id":5,"name":"北京","name_en":"Beijing","name_pinyin":"bei jing|bj","score":190,"level":3,"path":".1.5.93.","published":true,"is_in_china":true,"inspiration_activities_count":108,"activity_collections_count":13,"wishes_count":35282,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/93/30cba7db5b7e19beefa9b128a5f54606.jpg","lat":39.9042,"lng":116.407},{"id":90,"district_id":21,"parent_id":5,"name":"厦门","name_en":"Xiamen","name_pinyin":"sha men|sm","score":180,"level":3,"path":".1.5.90.","published":true,"is_in_china":true,"inspiration_activities_count":75,"activity_collections_count":11,"wishes_count":49808,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/90/cadbb5cb0d246026978a41c8a6c18895.jpg","lat":24.4865,"lng":118.089},{"id":437,"district_id":100051,"parent_id":5,"name":"广东","name_en":"Guangdong","name_pinyin":"guang dong|gd","score":150,"level":3,"path":".1.5.437.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/437/5b4ffe996346e3b7780e7e87e949a31d.jpg","lat":23.1322,"lng":113.267},{"id":416,"district_id":100065,"parent_id":5,"name":"浙江","name_en":"Zhejiang","name_pinyin":"zhe jiang|zj","score":130,"level":3,"path":".1.5.416.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":0,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/416/a77b87fe2a72e0897bdc8b4126065393.jpg","lat":30.2663,"lng":120.154},{"id":414,"district_id":100066,"parent_id":5,"name":"江苏","name_en":"Jiangsu","name_pinyin":"jiang su|js","score":120,"level":3,"path":".1.5.414.","published":true,"is_in_china":true,"inspiration_activities_count":0,"activity_collections_count":0,"wishes_count":18,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/414/9d24fbebf508f02c6d54e6a7208543d4.jpg","lat":32.0617,"lng":118.763}]
     */

    private List<DataEntity> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity implements Parcelable {
        private String name;
        private String region;
        /**
         * id : 109
         * district_id : 100007
         * parent_id : 5
         * name : 云南
         * name_en : Yunnan
         * name_pinyin : yun nan|yn
         * score : 1165
         * level : 3
         * path : .1.5.109.
         * published : true
         * is_in_china : true
         * inspiration_activities_count : 0
         * activity_collections_count : 0
         * wishes_count : 0
         * wiki_destination_id : null
         * photo_url : http://inspiration.chanyouji.cn/Destination/109/2b85ab3d7ebda3c321436a6147153f09.jpg
         * lat : 25.0454
         * lng : 102.71
         */

        private List<DestinationsEntity> destinations;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public List<DestinationsEntity> getDestinations() {
            return destinations;
        }

        public void setDestinations(List<DestinationsEntity> destinations) {
            this.destinations = destinations;
        }

        public static class DestinationsEntity implements Parcelable {

            private String title;

            private int id;
            private int district_id;
            private int parent_id;
            private String name;
            private String name_en;
            private String name_pinyin;
            private int score;
            private int level;
            private String path;
            private boolean published;
            private boolean is_in_china;
            private int inspiration_activities_count;
            private int activity_collections_count;
            private int wishes_count;
            private String wiki_destination_id;
            private String photo_url;
            private double lat;
            private double lng;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDistrict_id() {
                return district_id;
            }

            public void setDistrict_id(int district_id) {
                this.district_id = district_id;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getName_pinyin() {
                return name_pinyin;
            }

            public void setName_pinyin(String name_pinyin) {
                this.name_pinyin = name_pinyin;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public boolean isPublished() {
                return published;
            }

            public void setPublished(boolean published) {
                this.published = published;
            }

            public boolean isIs_in_china() {
                return is_in_china;
            }

            public void setIs_in_china(boolean is_in_china) {
                this.is_in_china = is_in_china;
            }

            public int getInspiration_activities_count() {
                return inspiration_activities_count;
            }

            public void setInspiration_activities_count(int inspiration_activities_count) {
                this.inspiration_activities_count = inspiration_activities_count;
            }

            public int getActivity_collections_count() {
                return activity_collections_count;
            }

            public void setActivity_collections_count(int activity_collections_count) {
                this.activity_collections_count = activity_collections_count;
            }

            public int getWishes_count() {
                return wishes_count;
            }

            public void setWishes_count(int wishes_count) {
                this.wishes_count = wishes_count;
            }

            public String getWiki_destination_id() {
                return wiki_destination_id;
            }

            public void setWiki_destination_id(String wiki_destination_id) {
                this.wiki_destination_id = wiki_destination_id;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeInt(this.district_id);
                dest.writeInt(this.parent_id);
                dest.writeString(this.name);
                dest.writeString(this.name_en);
                dest.writeString(this.name_pinyin);
                dest.writeInt(this.score);
                dest.writeInt(this.level);
                dest.writeString(this.path);
                dest.writeByte(published ? (byte) 1 : (byte) 0);
                dest.writeByte(is_in_china ? (byte) 1 : (byte) 0);
                dest.writeInt(this.inspiration_activities_count);
                dest.writeInt(this.activity_collections_count);
                dest.writeInt(this.wishes_count);
                dest.writeString(this.wiki_destination_id);
                dest.writeString(this.photo_url);
                dest.writeDouble(this.lat);
                dest.writeDouble(this.lng);
                dest.writeString(this.title);
            }

            public DestinationsEntity() {
            }

            protected DestinationsEntity(Parcel in) {
                this.id = in.readInt();
                this.district_id = in.readInt();
                this.parent_id = in.readInt();
                this.name = in.readString();
                this.name_en = in.readString();
                this.name_pinyin = in.readString();
                this.score = in.readInt();
                this.level = in.readInt();
                this.path = in.readString();
                this.published = in.readByte() != 0;
                this.is_in_china = in.readByte() != 0;
                this.inspiration_activities_count = in.readInt();
                this.activity_collections_count = in.readInt();
                this.wishes_count = in.readInt();
                this.wiki_destination_id = in.readString();
                this.photo_url = in.readString();
                this.lat = in.readDouble();
                this.lng = in.readDouble();
                this.title = in.readString();
            }

            public static final Creator<DestinationsEntity> CREATOR = new Creator<DestinationsEntity>() {
                @Override
                public DestinationsEntity createFromParcel(Parcel source) {
                    return new DestinationsEntity(source);
                }

                @Override
                public DestinationsEntity[] newArray(int size) {
                    return new DestinationsEntity[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.region);
            dest.writeTypedList(destinations);
        }

        public DataEntity() {
        }

        protected DataEntity(Parcel in) {
            this.name = in.readString();
            this.region = in.readString();
            this.destinations = in.createTypedArrayList(DestinationsEntity.CREATOR);
        }

        public static final Creator<DataEntity> CREATOR = new Creator<DataEntity>() {
            @Override
            public DataEntity createFromParcel(Parcel source) {
                return new DataEntity(source);
            }

            @Override
            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
        dest.writeInt(this.status);
        dest.writeTypedList(data);
    }

    public Destinations() {
    }

    protected Destinations(Parcel in) {
        this.message = in.readString();
        this.status = in.readInt();
        this.data = in.createTypedArrayList(DataEntity.CREATOR);
    }

    public static final Creator<Destinations> CREATOR = new Creator<Destinations>() {
        @Override
        public Destinations createFromParcel(Parcel source) {
            return new Destinations(source);
        }

        @Override
        public Destinations[] newArray(int size) {
            return new Destinations[size];
        }
    };

    @Override
    public String toString() {
        return "Destinations{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
