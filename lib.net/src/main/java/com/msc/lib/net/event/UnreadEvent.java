package com.msc.lib.net.event;

import com.msc.lib.net.bean.Unread;

/**
 * Created by msc on 2016/3/28.
 */
public class UnreadEvent extends Event {

    private Unread result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public UnreadEvent(Unread result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public Unread getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
