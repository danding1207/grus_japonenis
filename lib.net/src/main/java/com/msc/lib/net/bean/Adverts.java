package com.msc.lib.net.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by msc on 2016/3/28.
 */
public class Adverts implements Parcelable {

    /**
     * message : ok
     * status : 200
     * data : [{"photo":{"width":1280,"height":600,"photo_url":"http://inspiration.chanyouji.cn/Advert/67/8edf489aa947b079607b9e179f1a9370.jpg"},"id":67,"ios_url":"","android_url":"","target_id":"35","advert_type":"album","topic":"带着萌娃游世界","market":"all","open_in_browser":false},{"photo":{"width":1280,"height":600,"photo_url":"http://inspiration.chanyouji.cn/Advert/59/1f8623e6eb9e330d652b4aa20bc22919.jpg"},"id":59,"ios_url":"","android_url":"","target_id":"30","advert_type":"album","topic":"精选游记连环奖","market":"all","open_in_browser":false},{"photo":{"width":1280,"height":600,"photo_url":"http://inspiration.chanyouji.cn/Advert/66/eb18181bb17d4fdacab7cec181734eda.jpg"},"id":66,"ios_url":"","android_url":"","target_id":"38","advert_type":"album","topic":"带你赏遍日本樱花海","market":"all","open_in_browser":false},{"photo":{"width":1280,"height":600,"photo_url":"http://inspiration.chanyouji.cn/Advert/24/9dc7315c402e028674eca487a309a596.jpg"},"id":24,"ios_url":"","android_url":"","target_id":"1","advert_type":"album","topic":"写游记也能拿红包","market":"all","open_in_browser":false}]
     */

    private String message;
    private int status;
    /**
     * photo : {"width":1280,"height":600,"photo_url":"http://inspiration.chanyouji.cn/Advert/67/8edf489aa947b079607b9e179f1a9370.jpg"}
     * id : 67
     * ios_url :
     * android_url :
     * target_id : 35
     * advert_type : album
     * topic : 带着萌娃游世界
     * market : all
     * open_in_browser : false
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
        /**
         * width : 1280
         * height : 600
         * photo_url : http://inspiration.chanyouji.cn/Advert/67/8edf489aa947b079607b9e179f1a9370.jpg
         */

        private PhotoEntity photo;
        private int id;
        private String ios_url;
        private String android_url;
        private String target_id;
        private String advert_type;
        private String topic;
        private String market;
        private boolean open_in_browser;

        public PhotoEntity getPhoto() {
            return photo;
        }

        public void setPhoto(PhotoEntity photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIos_url() {
            return ios_url;
        }

        public void setIos_url(String ios_url) {
            this.ios_url = ios_url;
        }

        public String getAndroid_url() {
            return android_url;
        }

        public void setAndroid_url(String android_url) {
            this.android_url = android_url;
        }

        public String getTarget_id() {
            return target_id;
        }

        public void setTarget_id(String target_id) {
            this.target_id = target_id;
        }

        public String getAdvert_type() {
            return advert_type;
        }

        public void setAdvert_type(String advert_type) {
            this.advert_type = advert_type;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public boolean isOpen_in_browser() {
            return open_in_browser;
        }

        public void setOpen_in_browser(boolean open_in_browser) {
            this.open_in_browser = open_in_browser;
        }

        public static class PhotoEntity implements Parcelable {
            private int width;
            private int height;
            private String photo_url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.width);
                dest.writeInt(this.height);
                dest.writeString(this.photo_url);
            }

            public PhotoEntity() {
            }

            protected PhotoEntity(Parcel in) {
                this.width = in.readInt();
                this.height = in.readInt();
                this.photo_url = in.readString();
            }

            public static final Creator<PhotoEntity> CREATOR = new Creator<PhotoEntity>() {
                @Override
                public PhotoEntity createFromParcel(Parcel source) {
                    return new PhotoEntity(source);
                }

                @Override
                public PhotoEntity[] newArray(int size) {
                    return new PhotoEntity[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.photo, flags);
            dest.writeInt(this.id);
            dest.writeString(this.ios_url);
            dest.writeString(this.android_url);
            dest.writeString(this.target_id);
            dest.writeString(this.advert_type);
            dest.writeString(this.topic);
            dest.writeString(this.market);
            dest.writeByte(open_in_browser ? (byte) 1 : (byte) 0);
        }

        public DataEntity() {
        }

        protected DataEntity(Parcel in) {
            this.photo = in.readParcelable(PhotoEntity.class.getClassLoader());
            this.id = in.readInt();
            this.ios_url = in.readString();
            this.android_url = in.readString();
            this.target_id = in.readString();
            this.advert_type = in.readString();
            this.topic = in.readString();
            this.market = in.readString();
            this.open_in_browser = in.readByte() != 0;
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

    public Adverts() {
    }

    protected Adverts(Parcel in) {
        this.message = in.readString();
        this.status = in.readInt();
        this.data = in.createTypedArrayList(DataEntity.CREATOR);
    }

    public static final Creator<Adverts> CREATOR = new Creator<Adverts>() {
        @Override
        public Adverts createFromParcel(Parcel source) {
            return new Adverts(source);
        }

        @Override
        public Adverts[] newArray(int size) {
            return new Adverts[size];
        }
    };


    @Override
    public String toString() {
        return "Adverts{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
