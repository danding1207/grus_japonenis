package com.msc.lib.net.event;

import com.msc.lib.net.bean.Adverts;

/**
 * Created by msc on 2016/3/28.
 */
public class AdvertsEvent extends Event {

    private Adverts result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public AdvertsEvent(Adverts result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public Adverts getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
