package com.msc.lib.net.event;

import com.msc.lib.net.bean.TimelinesFollows;

/**
 * Created by msc on 2016/3/28.
 */
public class TimelinesFollowsEvent extends Event {

    private TimelinesFollows result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public TimelinesFollowsEvent(TimelinesFollows result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public TimelinesFollows getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
