package com.msc.lib.net.event;

import com.msc.lib.net.bean.ActivitiesPage;

/**
 * Created by msc on 2016/3/28.
 */
public class ActivitiesPageEvent extends Event {

    private ActivitiesPage result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public ActivitiesPageEvent(ActivitiesPage result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public ActivitiesPage getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
