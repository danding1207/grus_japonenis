package com.msc.lib.net.event;

import com.msc.lib.net.bean.DestinationsNearby;

/**
 * Created by msc on 2016/3/28.
 */
public class DestinationsNearbyEvent extends Event {

    private DestinationsNearby result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public DestinationsNearbyEvent(DestinationsNearby result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public DestinationsNearby getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
