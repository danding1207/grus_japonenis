package com.msc.lib.net.event;

import com.msc.lib.net.bean.Destinations;

/**
 * Created by msc on 2016/3/28.
 */
public class DestinationsEvent extends Event {

    private Destinations result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public DestinationsEvent(Destinations result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public Destinations getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
