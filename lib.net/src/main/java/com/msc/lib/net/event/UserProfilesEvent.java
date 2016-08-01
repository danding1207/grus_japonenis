package com.msc.lib.net.event;

import com.msc.lib.net.bean.UserProfiles;

/**
 * Created by msc on 2016/3/28.
 */
public class UserProfilesEvent extends Event {

    private UserProfiles result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public UserProfilesEvent(UserProfiles result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public UserProfiles getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
