package com.msc.lib.net.event;

import com.msc.lib.net.bean.DestinationsSearch;

/**
 * Created by msc on 2016/3/28.
 */
public class DestinationsSearchEvent extends Event {

    private DestinationsSearch result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public DestinationsSearchEvent(DestinationsSearch result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public DestinationsSearch getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
