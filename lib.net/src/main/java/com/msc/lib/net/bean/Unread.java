package com.msc.lib.net.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by msc on 2016/8/1.
 */

public class Unread implements Parcelable {


    /**
     * systems : 0
     * likes : 0
     * favorites : 0
     * follows : 0
     * comments : 0
     */

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.systems);
        dest.writeInt(this.likes);
        dest.writeInt(this.favorites);
        dest.writeInt(this.follows);
        dest.writeInt(this.comments);
    }

    public Unread() {
    }

    protected Unread(Parcel in) {
        this.systems = in.readInt();
        this.likes = in.readInt();
        this.favorites = in.readInt();
        this.follows = in.readInt();
        this.comments = in.readInt();
    }

    public static final Parcelable.Creator<Unread> CREATOR = new Parcelable.Creator<Unread>() {
        @Override
        public Unread createFromParcel(Parcel source) {
            return new Unread(source);
        }

        @Override
        public Unread[] newArray(int size) {
            return new Unread[size];
        }
    };
}
