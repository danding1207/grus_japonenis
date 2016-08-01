package com.msc.lib.net.bean;

/**
 * Created by msc on 2016/7/15.
 */

public class User {

    /**
     * message : ok
     * status : 200
     * data : {"id":302683,"photo_url":"http://inspiration.chanyouji.cn/User/302683/c8f3b70f9a0bd404f05256e8f422fded.jpg","name":"msc1207","gender":1,"level":1,"memo":null,"email":"1055904860@qq.com","introduce":null,"user_activities_count":0,"followings_count":10,"followers_count":0,"wishes_count":0,"favorites_count":1,"is_device_user":false,"unread_notifications_count":{"systems":0,"likes":0,"favorites":0,"follows":0,"comments":0},"header_photo":{"photo_url":"http://inspiration.chanyouji.cn/UserHeaderPhoto/302683/0c58a92495a7985fe7ca3247ccfa3ca1.jpg","width":8192,"height":1321},"encrypted_token":"JDJhJDEwJFdMVnltYkcuUWpiY0tCS0xsUVIzYk9sWG44OExhOGpuRHJWRzJsVEtPeFBlSlpNajJZSmx5"}
     */

    private String message;
    private int status;
    /**
     * id : 302683
     * photo_url : http://inspiration.chanyouji.cn/User/302683/c8f3b70f9a0bd404f05256e8f422fded.jpg
     * name : msc1207
     * gender : 1
     * level : 1
     * memo : null
     * email : 1055904860@qq.com
     * introduce : null
     * user_activities_count : 0
     * followings_count : 10
     * followers_count : 0
     * wishes_count : 0
     * favorites_count : 1
     * is_device_user : false
     * unread_notifications_count : {"systems":0,"likes":0,"favorites":0,"follows":0,"comments":0}
     * header_photo : {"photo_url":"http://inspiration.chanyouji.cn/UserHeaderPhoto/302683/0c58a92495a7985fe7ca3247ccfa3ca1.jpg","width":8192,"height":1321}
     * encrypted_token : JDJhJDEwJFdMVnltYkcuUWpiY0tCS0xsUVIzYk9sWG44OExhOGpuRHJWRzJsVEtPeFBlSlpNajJZSmx5
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String photo_url;
        private String name;
        private int gender;
        private int level;
        private Object memo;
        private String email;
        private Object introduce;
        private int user_activities_count;
        private int followings_count;
        private int followers_count;
        private int wishes_count;
        private int favorites_count;
        private boolean is_device_user;
        /**
         * systems : 0
         * likes : 0
         * favorites : 0
         * follows : 0
         * comments : 0
         */

        private UnreadNotificationsCountBean unread_notifications_count;
        /**
         * photo_url : http://inspiration.chanyouji.cn/UserHeaderPhoto/302683/0c58a92495a7985fe7ca3247ccfa3ca1.jpg
         * width : 8192
         * height : 1321
         */

        private HeaderPhotoBean header_photo;
        private String encrypted_token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Object getMemo() {
            return memo;
        }

        public void setMemo(Object memo) {
            this.memo = memo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getIntroduce() {
            return introduce;
        }

        public void setIntroduce(Object introduce) {
            this.introduce = introduce;
        }

        public int getUser_activities_count() {
            return user_activities_count;
        }

        public void setUser_activities_count(int user_activities_count) {
            this.user_activities_count = user_activities_count;
        }

        public int getFollowings_count() {
            return followings_count;
        }

        public void setFollowings_count(int followings_count) {
            this.followings_count = followings_count;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public int getWishes_count() {
            return wishes_count;
        }

        public void setWishes_count(int wishes_count) {
            this.wishes_count = wishes_count;
        }

        public int getFavorites_count() {
            return favorites_count;
        }

        public void setFavorites_count(int favorites_count) {
            this.favorites_count = favorites_count;
        }

        public boolean isIs_device_user() {
            return is_device_user;
        }

        public void setIs_device_user(boolean is_device_user) {
            this.is_device_user = is_device_user;
        }

        public UnreadNotificationsCountBean getUnread_notifications_count() {
            return unread_notifications_count;
        }

        public void setUnread_notifications_count(UnreadNotificationsCountBean unread_notifications_count) {
            this.unread_notifications_count = unread_notifications_count;
        }

        public HeaderPhotoBean getHeader_photo() {
            return header_photo;
        }

        public void setHeader_photo(HeaderPhotoBean header_photo) {
            this.header_photo = header_photo;
        }

        public String getEncrypted_token() {
            return encrypted_token;
        }

        public void setEncrypted_token(String encrypted_token) {
            this.encrypted_token = encrypted_token;
        }

        public static class UnreadNotificationsCountBean {
            private int systems;
            private int likes;
            private int favorites;
            private int follows;
            private int comments;

            public int getSystems() {
                return systems;
            }

            public void setSystems(int systems) {
                this.systems = systems;
            }

            public int getLikes() {
                return likes;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }

            public int getFavorites() {
                return favorites;
            }

            public void setFavorites(int favorites) {
                this.favorites = favorites;
            }

            public int getFollows() {
                return follows;
            }

            public void setFollows(int follows) {
                this.follows = follows;
            }

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }
        }

        public static class HeaderPhotoBean {
            private String photo_url;
            private int width;
            private int height;

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

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
        }
    }
}
