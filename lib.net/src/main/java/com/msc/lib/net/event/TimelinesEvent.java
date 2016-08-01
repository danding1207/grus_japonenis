package com.msc.lib.net.event;

import com.msc.lib.net.bean.Timelines;

/**
 * Created by msc on 2016/3/28.
 */
public class TimelinesEvent extends Event {

    private Timelines result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public TimelinesEvent(Timelines result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public Timelines getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
