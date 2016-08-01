package com.msc.lib.net.bean;

import java.util.List;

/**
 * Created by msc on 2016/3/31.
 */
public class TimelinesFollows {
    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        ss.append("TimelinesFollows{");
        ss.append("message=" + message);
        ss.append(", status=" + status);
        ss.append(", data=[");
        for (DataEntity dataEntity : data) {
            ss.append(dataEntity.toString() + ",");
        }
        ss.append("]}");
        return ss.toString();
    }

    /**
     * message : ok
     * status : 200
     * data : [{"id":48143,"name":"76无穷","level":3,"photo_url":"http://inspiration.chanyouji.cn/User/48143/9b3639e0f9602913c89b0f4e2777eb78.jpg","latest_activity":{"id":43161,"topic":"#新西兰29天房车自驾# D22 巨人的弹珠"}},{"id":14782,"name":"小丫么小神婆","level":4,"photo_url":"http://inspiration.chanyouji.cn/User/14782/1acd7f1f873ff912eac9ea2b6fedc97e.jpg","latest_activity":{"id":43173,"topic":"吉尼斯群体长发之最：黄洛瑶寨"}}]
     */

    private String message;
    private int status;
    /**
     * id : 48143
     * name : 76无穷
     * level : 3
     * photo_url : http://inspiration.chanyouji.cn/User/48143/9b3639e0f9602913c89b0f4e2777eb78.jpg
     * latest_activity : {"id":43161,"topic":"#新西兰29天房车自驾# D22 巨人的弹珠"}
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

    public static class DataEntity {
        private int id;
        private String name;
        private int level;
        private String photo_url;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", photo_url='" + photo_url + '\'' +
                    ", latest_activity=" + latest_activity +
                    '}';
        }

        /**
         * id : 43161
         * topic : #新西兰29天房车自驾# D22 巨人的弹珠
         */

        private LatestActivityEntity latest_activity;

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

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public LatestActivityEntity getLatest_activity() {
            return latest_activity;
        }

        public void setLatest_activity(LatestActivityEntity latest_activity) {
            this.latest_activity = latest_activity;
        }

        public static class LatestActivityEntity {
            private int id;
            private String topic;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTopic() {
                return topic;
            }

            public void setTopic(String topic) {
                this.topic = topic;
            }
        }
    }
}
