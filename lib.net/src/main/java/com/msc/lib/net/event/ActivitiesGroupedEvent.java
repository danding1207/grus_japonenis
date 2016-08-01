package com.msc.lib.net.event;

import com.msc.lib.net.bean.ActivitiesGrouped;

/**
 * Created by msc on 2016/3/28.
 */
public class ActivitiesGroupedEvent extends Event {

    private ActivitiesGrouped result;
    private Constant.GetResultWay getResultWay;
    private Throwable throwable;

    public ActivitiesGroupedEvent(ActivitiesGrouped result, Constant.GetResultWay getResultWay, Throwable throwable) {
        this.result = result;
        this.throwable = throwable;
        this.getResultWay = getResultWay;
    }

    public ActivitiesGrouped getResult() {
        return result;
    }

    public Constant.GetResultWay getGetResultWay() {
        return getResultWay;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}
