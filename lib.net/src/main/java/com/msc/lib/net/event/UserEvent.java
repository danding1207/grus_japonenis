package com.msc.lib.net.event;

import com.msc.lib.net.bean.User;

/**
 * Created by msc on 2016/3/28.
 */
public class UserEvent extends Event {

    private User result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public UserEvent(User result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public User getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
