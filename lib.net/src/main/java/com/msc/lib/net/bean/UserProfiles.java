package com.msc.lib.net.bean;

/**
 * Created by msc on 2016/5/6.
 */
public class UserProfiles {

    /**
     * message : ok
     * status : 200
     * data : {"id":2064,"name":"粉团子","email":"princess@since1985.me","gender":0,"level":4,"photo_url":"http://inspiration.chanyouji.cn/User/2064/8d47e422bcbefcee39c1738ace661ece.jpg","followings_count":327,"followers_count":1472,"user_activities_count":267,"wishes_count":56,"favorites_count":0,"header_photo":{"photo_url":"http://inspiration.chanyouji.cn/UserHeaderPhoto/2064/99080dc3d59e29e96179ab5cf047444e.jpg","width":1200,"height":799},"is_follow":true,"follow_each_other":false}
     */

    private String message;
    private int status;
    /**
     * id : 2064
     * name : 粉团子
     * email : princess@since1985.me
     * gender : 0
     * level : 4
     * photo_url : http://inspiration.chanyouji.cn/User/2064/8d47e422bcbefcee39c1738ace661ece.jpg
     * followings_count : 327
     * followers_count : 1472
     * user_activities_count : 267
     * wishes_count : 56
     * favorites_count : 0
     * header_photo : {"photo_url":"http://inspiration.chanyouji.cn/UserHeaderPhoto/2064/99080dc3d59e29e96179ab5cf047444e.jpg","width":1200,"height":799}
     * is_follow : true
     * follow_each_other : false
     */

    private DataEntity data;

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

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private int id;
        private String name;
        private String email;
        private int gender;
        private int level;
        private String photo_url;
        private String followings_count;
        private String followers_count;
        private int user_activities_count;
        private int wishes_count;
        private int favorites_count;
        /**
         * photo_url : http://inspiration.chanyouji.cn/UserHeaderPhoto/2064/99080dc3d59e29e96179ab5cf047444e.jpg
         * width : 1200
         * height : 799
         */

        private HeaderPhotoEntity header_photo;
        private boolean is_follow;
        private boolean follow_each_other;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public String getFollowings_count() {
            return followings_count;
        }

        public void setFollowings_count(String followings_count) {
            this.followings_count = followings_count;
        }

        public String getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(String followers_count) {
            this.followers_count = followers_count;
        }

        public int getUser_activities_count() {
            return user_activities_count;
        }

        public void setUser_activities_count(int user_activities_count) {
            this.user_activities_count = user_activities_count;
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

        public HeaderPhotoEntity getHeader_photo() {
            return header_photo;
        }

        public void setHeader_photo(HeaderPhotoEntity header_photo) {
            this.header_photo = header_photo;
        }

        public boolean isIs_follow() {
            return is_follow;
        }

        public void setIs_follow(boolean is_follow) {
            this.is_follow = is_follow;
        }

        public boolean isFollow_each_other() {
            return follow_each_other;
        }

        public void setFollow_each_other(boolean follow_each_other) {
            this.follow_each_other = follow_each_other;
        }

        public static class HeaderPhotoEntity {
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
